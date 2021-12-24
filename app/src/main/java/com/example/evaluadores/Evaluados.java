package com.example.evaluadores;

public class Evaluados
{
    private String id;
    private String idevaluado;
    private String nombres;
    private String genero;
    private String situacion;
    private String cargo;
    private String fechaInicio;
    private String fechaFin;
    private String imgJPG;
    private String imgjpg;

    public Evaluados()
    {

    }

    public Evaluados(String id, String idevaluado, String nombres, String genero, String situacion, String cargo, String fechaInicio, String fechaFin, String imgJPG, String imgjpg)
    {
        this.id = id;
        this.idevaluado = idevaluado;
        this.nombres = nombres;
        this.genero = genero;
        this.situacion = situacion;
        this.cargo = cargo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.imgJPG = imgJPG;
        this.imgjpg = imgjpg;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getIdevaluado()
    {
        return idevaluado;
    }

    public void setIdevaluado(String idevaluado)
    {
        this.idevaluado = idevaluado;
    }

    public String getNombres()
    {
        return nombres;
    }

    public void setNombres(String nombres)
    {
        this.nombres = nombres;
    }

    public String getGenero()
    {
        return genero;
    }

    public void setGenero(String genero)
    {
        this.genero = genero;
    }

    public String getSituacion()
    {
        return situacion;
    }

    public void setSituacion(String situacion)
    {
        this.situacion = situacion;
    }

    public String getCargo()
    {
        return cargo;
    }

    public void setCargo(String cargo)
    {
        this.cargo = cargo;
    }

    public String getFechaInicio()
    {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio)
    {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin()
    {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin)
    {
        this.fechaFin = fechaFin;
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
