package com.example.evaluadores;

public class Evaluadores
{
    private String idevaluador;
    private String nombres;
    private String area;
    private String imgJPG;
    private String imgjpg;

    public Evaluadores()
    {

    }

    public Evaluadores(String idevaluador, String nombres, String area, String imgJPG, String imgjpg)
    {
        this.idevaluador = idevaluador;
        this.nombres = nombres;
        this.area = area;
        this.imgJPG = imgJPG;
        this.imgjpg = imgjpg;
    }

    public String getIdevaluador()
    {
        return idevaluador;
    }

    public void setIdevaluador(String idevaluador)
    {
        this.idevaluador = idevaluador;
    }

    public String getNombres()
    {
        return nombres;
    }

    public void setNombres(String nombres)
    {
        this.nombres = nombres;
    }

    public String getArea()
    {
        return area;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public String getImgJPG()
    {
        return imgJPG;
    }

    public void setImgJPG(String imgJPG)
    {
        this.imgJPG = imgJPG;
    }

    public String getImgjpg()
    {
        return imgjpg;
    }

    public void setImgjpg(String imgjpg)
    {
        this.imgjpg = imgjpg;
    }
}
