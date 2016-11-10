package com.example.xpalacin.culoocodo;


/**
 * Created by xpalacin on 28/10/16.
 */

public class Pregunta {
    private static int count = 0;
    private int id;
    private int imageId;
    private boolean type;
    private Respuesta answer;

    public Pregunta(boolean n_type, int n_imageId, int n_respuesta_imageId){
        id = ++count;
        answer = new Respuesta(n_respuesta_imageId);
        type = n_type;
        imageId = n_imageId;
    }

    public int getId(){
        return id;
    }

    public boolean getType(){
        return type;
    }


    public int getImageId(){
        return imageId;
    }

    public Respuesta getAsnwer(){
        return answer;
    }

}
