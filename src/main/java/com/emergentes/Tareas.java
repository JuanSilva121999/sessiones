package com.emergentes;


public class Tareas {
    private int id;
    private String tarea;
    private boolean estado;

    public Tareas() {
    }

    public Tareas(int id, String tarea, boolean estado) {
        this.id = id;
        this.tarea = tarea;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
