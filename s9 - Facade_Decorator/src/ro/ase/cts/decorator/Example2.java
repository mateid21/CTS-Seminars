package ro.ase.cts.decorator;

interface FileOperation {
    String read();
    void write(String content);
}

class FileOperationConcrete implements FileOperation {
    private String fileContents = "Initial Content";

    @Override
    public String read() {
        return fileContents;
    }

    @Override
    public void write(String content) {
        this.fileContents = content;
    }
}

class SecurityDecorator implements FileOperation {
    private FileOperation fileOperation;

    SecurityDecorator(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    @Override
    public String read() {
        if(checkAccess()) {
            return fileOperation.read();
        } else {
            return "Access Denied";
        }
    }

    @Override
    public void write(String content) {
        if(checkAccess()) {
            fileOperation.write(content);
        } else {
            System.out.println("Write Operation Denied");
        }
    }

    private boolean checkAccess() {
        System.out.println("Security Check Passed");
        return true;
    }
}

public class Example2 {
    public static void main(String[] args) {
        FileOperation file = new FileOperationConcrete();

        FileOperation secureFile = new SecurityDecorator(file);

        String fileContents = secureFile.read();
        System.out.println(fileContents);

        secureFile.write("New Content");
        System.out.println(secureFile.read());
    }
}
