package servlets;

public class data1 {

    private byte dia;
    private byte mes;
    private short ano;
    
    public data1() {
    	this.dia = 1;
    	this.mes = 1;
    	this.ano = 1;
    }

    private int[] mes30dias = {4, 6, 9, 11};

    public data1(int dia, int mes, int ano) {
        this();
        setdia(dia);
        this.mes =(byte)mes;
        this.ano = (short)ano;
    }

    public int getDia() {
        return this.dia;
    }

    public void setdia(int dia) throws IllegalArgumentException {
        if (dia < 1 | dia > 31) {
            throw new IllegalArgumentException("data invalida");
        }
        this.dia = (byte)dia;
    }

    public int getMes() {
        return this.mes;
    }

    public void setmes(int mes) throws IllegalArgumentException {
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("data invalida");
        }
        if (Array.in(mes, this.mes30dias) && this.getDia() > 30) {
            throw new IllegalArgumentException("data invalida");
        }
        if (mes == 2 && this.getDia() > 29) {
            throw new IllegalArgumentException("data invalida");
        }
        if (!isLeapano(this.getAno()) && this.getDia() > 28) {
            throw new IllegalArgumentException("data invalida");
        }
        this.mes = (byte)mes;
    }

    public int getAno() {
        return this.ano;
    }

    public void setano(int ano) throws IllegalArgumentException{
        if (ano < 1) {
            throw new IllegalArgumentException("data invalida");
        }
        this.ano = (short) ano;
    }

    public static boolean isLeapano(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0;
    }

    public String toString() {
        return this.getDia() + "/" + this.getMes() + "/" + this.getAno();
    }
}