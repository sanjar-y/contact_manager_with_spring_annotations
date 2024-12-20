package conact_manager.service;

import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class ScannerService {
    private Scanner strScanner;
    private Scanner numScanner;

    public ScannerService() {
        strScanner = new Scanner(System.in);
        numScanner = new Scanner(System.in);
    }

    public Scanner getStrScanner() {
        return strScanner;
    }

    public Scanner getNumScanner() {
        return numScanner;
    }
}
