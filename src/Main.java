import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/*
Текстовый файл состоит не более чем из 106 символов X, Y и Z.
Определите длину самой длинной последовательности, состоящей из символов X.
Хотя бы один символ X находится в последовательности.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = ("C:\\Users\\Мария\\IdeaProjects\\xxx\\src\\24_demo.txt");
        int lenMax = 0; //максимальная длина
        int lenCur = 0; //текущая длина
        char x = 'X';
        try {
            Path filePath = Paths.get(fileName);
            List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);

            for (String l : lines){
                for (char c : l.toCharArray()){
                    if(c == x){
                        lenCur++;
                    }else{
                        if (lenCur > lenMax){
                            lenMax = lenCur;
                        }
                        lenCur = 0;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("самя большая последовательность X: " + lenMax);
    }
}