package com.example.semanas4eco;

public class Nota {
    double porParcial;
    double porQuices;
    double porEjericios;
    double porProyectos;
    double nP1;
    double nP2;
    double nEjercios;
    double nPro1;
    double nPro2;
    double nQuices;

    double notaFinal;

    public Nota(double nP1, double nP2, double nEjercios, double nPro1, double nPro2, double nQuices){

        nP1 = this.nP1;
        nP2 = this.nP2;
        nEjercios = this.nEjercios;
        nPro1 = this.nPro1;
        nPro2 = this.nPro2;
        nQuices = this.nQuices;

        //Porcentajes

        porParcial = 0.15;
        porQuices = 0.15;
        porProyectos = 0.25;
        porEjericios = 0.05;

        //calculoNota final
        notaFinal = (nPro1 * porProyectos)+(nPro2 * porProyectos)+(nP1 * porParcial)+
                (nP2 * porParcial)+(nQuices * porQuices)+(nEjercios * porEjericios);

    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }
}
