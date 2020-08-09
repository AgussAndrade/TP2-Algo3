//package edu.fiuba.algo3.modelo;
//
//import edu.fiuba.algo3.modelo.estrategias.Clasica;
//import edu.fiuba.algo3.modelo.estrategias.Penalizable;
//import edu.fiuba.algo3.modelo.estrategias.PuntajeParcial;
//import edu.fiuba.algo3.modelo.opciones.Opcion;
//import edu.fiuba.algo3.modelo.preguntas.*;
//
//import java.util.List;
//
//public class PreguntaFactory {
//    private List<Pregunta> preguntas;
//
//    public void crearVerdaderoFalsoClasica(String enunciado,List<Opcion> opciones){
//        if (!(comprobarCantidadDeOpciones(opciones,2,2))){
//            //TIRAR EXCEPCION//
//        }
//        VerdaderoFalso verdaderoFalsoClasica = new VerdaderoFalso(enunciado, opciones, new Clasica());
//        this.preguntas.add(verdaderoFalsoClasica);
//    }
//
//    public void crearVerdaderoFalsoPenalizable(String enunciado,List<Opcion> opciones){
//        if (!(comprobarCantidadDeOpciones(opciones,2,2))){
//            //TIRAR EXCEPCION//
//        }
//        VerdaderoFalso verdaderoFalsoPenalizable = new VerdaderoFalso(enunciado, opciones, new Penalizable());
//        this.preguntas.add(verdaderoFalsoPenalizable);
//    }
//
//    public void crearMultipleChoiceClasica(String enunciado,List<Opcion> opciones){
//        if (!(comprobarCantidadDeOpciones(opciones,2,5))){
//            //TIRAR EXCEPCION//
//        }
//        MultipleChoice multipleChoiceClasica = new MultipleChoice(enunciado, opciones, new Clasica());
//        this.preguntas.add(multipleChoiceClasica);
//
//    }
//
//    public void crearMultipleChoicePuntajeParcial(String enunciado,List<Opcion> opciones){
//        if (!(comprobarCantidadDeOpciones(opciones,2,5))){
//            //TIRAR EXCEPCION//
//        }
//        MultipleChoice multipleChoicePuntajeParcial = new MultipleChoice(enunciado, opciones, new PuntajeParcial());
//        this.preguntas.add(multipleChoicePuntajeParcial);
//
//    }
//
//    public void crearMultipleChoicePenalizable(String enunciado,List<Opcion> opciones){
//        if (!(comprobarCantidadDeOpciones(opciones,2,5))){
//            //TIRAR EXCEPCION//
//        }
//        MultipleChoice multipleChoicePenalizable = new MultipleChoice(enunciado, opciones, new Penalizable());
//        this.preguntas.add(multipleChoicePenalizable);
//
//    }
//
//    public void crearGroupChoice(String enunciado, List<Opcion> opciones){
//        if (!(comprobarCantidadDeOpciones(opciones, 2,6))){
//            //TIRAR EXCEPCION//
//        }
//        GroupChoice groupChoice = new GroupChoice(enunciado, opciones, new Clasica());
//        this.preguntas.add(groupChoice);
//    }
//
//    public void crearOrderedChoice(String enunciado, List<Opcion> opciones){
//        if (!(comprobarCantidadDeOpciones(opciones, 2, 5))){
//            //TIRAR EXCEPCION//
//        }
//        OrderedChoice orderedChoice = new OrderedChoice (enunciado, opciones, new Clasica());
//        this.preguntas.add(orderedChoice);
//
//    }
//
//    public List<Pregunta> getPreguntas(){
//        return preguntas;
//    }
//
//    public boolean comprobarCantidadDeOpciones(List<Opcion> opciones, int desde, int hasta) {
//        return (opciones.size() >= desde && opciones.size() <= hasta);
//
//    }
//}
//
//
//
//
