package Yaroslav.Zuban.Deeplay.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadingFile implements FileHandling {
    private String creatures = "Существа";
    private String obstacles = "Препядствия";
    private String cost = "Стоимость";

    private File file;

    public ReadingFile(File file) {
        this.file = file;
    }

    @Override
    public void workingFile(List<String> nameCreatures, List<String> nameObstacles, List<Integer> movingCost) throws FileNotFoundException {
        List<String> lineFile = new ArrayList<>();

        FileReader fileReader = new FileReader(file);
        Scanner scanner = new Scanner(fileReader);

        while (scanner.hasNext()) {
            lineFile.add(scanner.nextLine());
        }

        scanner.close();

        if (lineFile.contains(creatures)) {
            fillingList(nameCreatures, lineFile, creatures);
        }

        if (lineFile.contains(obstacles)) {
            fillingList(nameObstacles, lineFile, obstacles);
        }

        if (lineFile.contains(cost)) {
            costMovements(movingCost, lineFile, cost);
        }

    }

    private void costMovements(List<Integer> object, List<String> listFile, String line) {
        Pattern integerPattern = Pattern.compile("(\\-?\\d+)");
        String l;

        for (int i = listFile.indexOf(line) + 1; i < listFile.size() && listFile.get(i).compareTo(creatures) != 0
                && listFile.get(i).compareTo(obstacles) != 0 && listFile.get(i).compareTo(cost) != 0; i++) {
            l = listFile.get(i);

            Matcher matched = integerPattern.matcher(l);

            while (matched.find()) {
                object.add(Integer.valueOf(matched.group()));
            }
        }
    }

    private void fillingList(List<String> object, List<String> listFile, String line) {
        for (int i = listFile.indexOf(line) + 1; listFile.get(i).compareTo(creatures) != 0
                && listFile.get(i).compareTo(obstacles) != 0 && listFile.get(i).compareTo(cost) != 0 && i < listFile.size(); i++) {
            object.add(listFile.get(i));
        }
    }
}
