package modele;

public class ExceptionPlanning extends Exception implements ConstantesErreur {
    private final int chCodeErreur;

    public ExceptionPlanning(int parCodeErreur){
        chCodeErreur = parCodeErreur;
    }
    public int getChCodeErreur(){
        return chCodeErreur;
    }
    public String toString(){
        return ERREUR_PLANNING[chCodeErreur];
    }
}