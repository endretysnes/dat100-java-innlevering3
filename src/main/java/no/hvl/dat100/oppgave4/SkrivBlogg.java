package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

        String filvei = mappe + "/" + filnavn;

        try(PrintWriter skriver = new PrintWriter(filvei)){
            skriver.print(samling.toString());
            return true;

        }
        catch(FileNotFoundException e){
            System.out.println("Kunne ikke finne filplass");
            return false;
        }
	}
}
    