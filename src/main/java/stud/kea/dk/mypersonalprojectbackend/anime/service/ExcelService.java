package stud.kea.dk.mypersonalprojectbackend.anime.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import stud.kea.dk.mypersonalprojectbackend.anime.model.Anime;
import stud.kea.dk.mypersonalprojectbackend.anime.repository.AnimeRepository;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelService {
    private final AnimeRepository animeRepository;

    public ExcelService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public void importExcelFile(MultipartFile file) throws Exception {
        List<Anime> animeList = new ArrayList<>();

        // Read the Excel file
        try (InputStream inputStream = file.getInputStream();
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheetAt(0); // Get the first sheet

            // Loop through the rows and columns of the Excel file
            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Skip header row
                Row row = sheet.getRow(i);

                // Read data from the Excel file and map to Anime object
                Anime anime = new Anime();
                anime.setTitle(row.getCell(0).getStringCellValue()); // Title
                anime.setLink(row.getCell(1).getStringCellValue()); // Link
                anime.setGenre(row.getCell(2).getStringCellValue()); // Genre
                anime.setOpinion(row.getCell(3).getStringCellValue()); // Opinion

                // Handle 'watch_again' as a string
                anime.setWatch_again(row.getCell(4).getStringCellValue()); // Watch Again (true/false)

                // Handle 'times_watched' as an integer
                anime.setTimes_watched((int) row.getCell(5).getNumericCellValue()); // Times Watched

//                // Handle 'start_date' as a LocalDate
//                String startDateStr = row.getCell(6).getStringCellValue(); // Start Date (String)
//                if (!startDateStr.isEmpty()) {
//                    anime.setStart_date(LocalDate.parse(startDateStr)); // Parse into LocalDate
//                }
//
//                // Handle 'last_change' as a LocalDate
//                String lastChangeStr = row.getCell(7).getStringCellValue(); // Last Change (String)
//                if (!lastChangeStr.isEmpty()) {
//                    anime.setLast_change(LocalDate.parse(lastChangeStr)); // Parse into LocalDate
//                }

                anime.setRelease_date(row.getCell(6).getStringCellValue()); // Release Date
                anime.setSub_dub(row.getCell(7).getStringCellValue()); // Sub/Dub

                // Add the anime object to the list
                animeList.add(anime);
            }
        }

        // Save to the database
        animeRepository.saveAll(animeList); // Save all the anime objects to the database
    }
}
