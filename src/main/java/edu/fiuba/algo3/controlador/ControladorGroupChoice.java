package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.opciones.Binaria;
import edu.fiuba.algo3.modelo.opciones.Grupal;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributeView;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ControladorGroupChoice extends ControladorPregunta{
    public Label nombreJugador;
    public Label enunciadoPregunta;
    public Label tiempo;
    public Label puntajeJugador1;
    public Label puntajeJugador2;
    public Label nombreJugador2;
    public Label nombreJugador1;
    public Label opcion1,opcion2,opcion3,opcion4,opcion5,opcion6;
    public VBox BoxGrupoB,BoxGrupoA,BoxSinGrupo;
    private  List<Grupal> selecciones;
    public Label[] opciones;
    public VBox[] BoxGrupos;
    public Hashtable<String,Label> mapaDeOpciones = new Hashtable<>();
    public Hashtable<String,VBox> mapaDeGrupos = new Hashtable<>();

    public void initialize() {
        nombreJugador.setText(jugadores.get(jugadorActual).nombre());
        nombreJugador1.setText(jugadores.get(0).nombre());
        nombreJugador2.setText(jugadores.get(1).nombre());
        puntajeJugador1.setText(Integer.toString(jugadores.get(0).puntos()));
        puntajeJugador2.setText(Integer.toString(jugadores.get(1).puntos()));
        enunciadoPregunta.setText(preguntaActual.enunciado());
        selecciones = ((GroupChoice)preguntaActual).obtenerOpciones();
        constructorDeRespuestaActual.conResponsable(jugadores.get(jugadorActual));

        opciones = new Label[]{opcion1, opcion2, opcion3, opcion4, opcion5, opcion6};
        BoxGrupos = new VBox[]{BoxSinGrupo,BoxGrupoA,BoxGrupoB};
        int i=0,j=0;
        mapaDeGrupos.put("",BoxGrupos[j++]);
        for (Grupal opcion : selecciones){
            System.out.print(i+":"+ opcion.texto() + "\n");
            mapaDeOpciones.put(opcion.texto(),opciones[i]);
            opciones[i].setText(opcion.texto());
            if(!mapaDeGrupos.containsKey(opcion.grupo())){
                System.out.print(i +":" + opcion.grupo() +  "\n");
                mapaDeGrupos.put(opcion.grupo(),BoxGrupos[j]);
                j++;
            }
            i++;
        }
    }

    private void actualizarVistaDeListas(){
        System.out.print("actualizarListas:" + "\n");
        for (Grupal opcion : selecciones){
            System.out.print("opcion.grupoSeleccionado():" + opcion.grupoSeleccionado() + "\n");
            System.out.print("mapaDeGrupos.get(opcion.grupoSeleccionado()):" + mapaDeGrupos.get(opcion.grupoSeleccionado()) + "\n");
            System.out.print("contains:" + mapaDeGrupos.get(opcion.grupoSeleccionado()).getChildren().contains(mapaDeOpciones.get(opcion.texto())) + "\n");
            if (!mapaDeGrupos.get(opcion.grupoSeleccionado()).getChildren().contains(mapaDeOpciones.get(opcion.texto()))){
                System.out.print("recargo:" + "\n");
                mapaDeGrupos.get(opcion.grupoSeleccionado()).getChildren().add(mapaDeOpciones.get(opcion.texto()));
            }
        }
    }

    public void dragDetectedOpcion(MouseEvent mouseEvent) { //SOURCE
        System.out.print("dragOpcion:" + mouseEvent.getSource() + "\n");
        Dragboard db = ((Label)mouseEvent.getSource()).startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putString(((Label)mouseEvent.getSource()).getText());
        db.setContent(content);

        mouseEvent.consume();
    }

    public void dragDoneOpcion(DragEvent dragEvent) { //SOURCE
        System.out.print("dragDoneOpcion\n");
        if (dragEvent.getTransferMode() == TransferMode.COPY) {
            for (Grupal opcion : selecciones){
                if (opcion.texto().equals(((Label)dragEvent.getGestureSource()).getText())){
                    System.out.print("Listo el polio\n");
                    selecciones.get(0).seleccionar("A");
                }
            }
        }
        dragEvent.consume();
        actualizarVistaDeListas();
    }

    public void dragOverBox(DragEvent dragEvent) { //TARGET
        System.out.print("dragOverGrupoA\n");
        if (dragEvent.getGestureSource() != BoxGrupoA &&
                dragEvent.getDragboard().hasString()) {
            /* allow for both copying and moving, whatever user chooses */
            dragEvent.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }

        dragEvent.consume();
    }

    public void dragEnteredBox(DragEvent dragEvent) { //TARGET
        System.out.print("dragEnteredGrupoA\n");
        if (dragEvent.getGestureSource() != BoxGrupoA &&
                dragEvent.getDragboard().hasString()) {
//            BoxGrupoA.
        }

        dragEvent.consume();
    }

    public void dragExitedBox(DragEvent dragEvent) { //TARGET
        System.out.print("DragExitedGrupoA\n");
//        BoxGrupoA.setSelected(false);
    }

    public void dragDroppedBox(DragEvent dragEvent) { //TARGET
        System.out.print("dragDroppedGrupoA\n");
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString()) {
//            BoxGrupoA.setText(db.getString());
            success = true;
        }
        dragEvent.setDropCompleted(success);

        dragEvent.consume();
    }



    public void responder(ActionEvent actionEvent) throws IOException {
        constructorDeRespuestaActual.conResponsable(jugadores.get(jugadorActual));
        constructorDeRespuestaActual.conSelecciones(List.copyOf(selecciones));
        respuestas.add(constructorDeRespuestaActual.build());
        continuar();
    }

    public void activarExclusividad(ActionEvent actionEvent) {
    }

    public void activarMultiplicadorX2(ActionEvent actionEvent) {
        constructorDeRespuestaActual.conMultiplicador(new Multiplicador(2));
    }

    public void activarMultiplicadorX3(ActionEvent actionEvent) {
        constructorDeRespuestaActual.conMultiplicador(new Multiplicador(3));
    }

}
