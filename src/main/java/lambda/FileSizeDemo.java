package lambda;

import com.google.common.base.Objects;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FileSize {

    private final File file;
    private final Long size;

    FileSize(File file, Long size) {
        this.file = file;
        this.size = size;
    }

    File getFile() {
        return file;
    }


    Long getSize() {
        return size;
    }


    String getName() {
        return getFile().getName();
    }


    String getFirstLetter() {
        return getName().substring(0, 1);
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("file", file)
                .add("size", size)
                .toString();
    }

}

public class FileSizeDemo {
    public static void main(String[] args) {
        File[] files = new File("/Users/tphuang/Documents/test/").listFiles();
        List<FileSize> result = Stream.of(files)
                .map(f -> new FileSize(f, f.length()))
                .collect(Collectors.toList());

       result.stream()
             .forEach(System.out::println);

        Map<String, List<FileSize>> result2 = Stream.of(files)
                .map(f -> new FileSize(f, f.length()))
                .collect(Collectors.groupingBy(FileSize::getFirstLetter));

        result2.get("j").stream().forEach(System.out::println);

        Optional<FileSize> filesize = Stream.of(files)
                .map(f -> new FileSize(f, f.length()))
                .reduce((fs1, fs2) -> fs1.getSize() > fs2.getSize() ? fs1 : fs2);

        System.out.println(filesize);


    }
}
