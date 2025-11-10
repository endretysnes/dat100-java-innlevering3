package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggTabell;
    private int nesteLedig;

	public Blogg() {
		innleggTabell = new Innlegg[20];
        this.nesteLedig = 0;
	}

	public Blogg(int lengde) {
        innleggTabell = new Innlegg[lengde];
        this.nesteLedig = 0;
	}

	public int getAntall() {
		return nesteLedig;
	}
	
	public Innlegg[] getSamling() {
		return innleggTabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
        for(int i = 0; i < nesteLedig; i++) {
            if (innleggTabell[i].erLik(innlegg)) {
                return i;
            }
        }
        return -1;
	}

	public boolean finnes(Innlegg innlegg) {
        return finnInnlegg(innlegg) != -1;
	}

	public boolean ledigPlass() {
        return nesteLedig < innleggTabell.length;
	}
	
	public boolean leggTil(Innlegg innlegg) {

        if(ledigPlass() && !finnes(innlegg)) {
            innleggTabell[nesteLedig] = innlegg;
            nesteLedig++;
            return true;
        }
        return false;
	}
	@Override
	public String toString() {
        String streng = nesteLedig + "\n";
        for(int i = 0; i < nesteLedig; i++){
            streng += innleggTabell[i].toString();
        }
		return streng;
    }

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
        Innlegg[] nyTab = new Innlegg[innleggTabell.length * 2];
        for(int i = 0; i < nesteLedig; i++){
            nyTab[i] = innleggTabell[i];
        }
        innleggTabell = nyTab;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

        if(!ledigPlass()){
            utvid();
        }
        if(finnes(innlegg)){
            return false;
        }
        leggTil(innlegg);
		return true;
	}
	
	public boolean slett(Innlegg innlegg) {
		int indeks = finnInnlegg(innlegg);
        if(indeks == -1){
            return false;
        }
        for(int i = indeks; i < nesteLedig -1; i++){
            innleggTabell[i] = innleggTabell[i+1];
        }
        innleggTabell[nesteLedig - 1] = null;
        nesteLedig--;
        return true;
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}