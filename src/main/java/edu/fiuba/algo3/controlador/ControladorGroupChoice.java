package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.opciones.Grupal;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
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
    private int multiplicador = 1;
    public Label opcion1,opcion2,opcion3,opcion4,opcion5,opcion6;
    public VBox BoxGrupoB,BoxGrupoA,BoxSinGrupo;
    private List<Grupal> selecciones;
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
        ajustarLabel(enunciadoPregunta);
        selecciones = ((GroupChoice)preguntaActual).obtenerOpciones();
        constructorDeRespuestaActual.conResponsable(jugadores.get(jugadorActual));

        opciones = new Label[]{opcion1, opcion2, opcion3, opcion4, opcion5, opcion6};
        BoxGrupos = new VBox[]{BoxSinGrupo,BoxGrupoA,BoxGrupoB};
        int i=0,j=0;
        mapaDeGrupos.put("sinGrupo",BoxGrupos[j++]);
        for (Grupal opcion : selecciones){
            mapaDeOpciones.put(opcion.texto(),opciones[i]);
            opciones[i].setText(opcion.texto());
            if(!mapaDeGrupos.containsKey(opcion.grupo())){
                mapaDeGrupos.put(opcion.grupo(),BoxGrupos[j]);
                j++;
            }
            i++;
        }
        iniciarTemporizador();
    }

    private void actualizarVistaDeListas(){
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

    public void dragDetectedOpcion(MouseEvent mouseEvent) { //SOURCE - cuando empezás a arrastrar
        Dragboard db = ((Label)mouseEvent.getSource()).startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putString(((Label)mouseEvent.getSource()).getText());
        db.setContent(content);

        mouseEvent.consume();
    }

    public void dragDoneOpcion(DragEvent dragEvent) { //SOURCE -  soltas el click y terminas de arrastrar
        if (dragEvent.getTransferMode() == TransferMode.COPY) {
                    System.out.print("if\n");
                    System.out.print(dragEvent.getGestureTarget().getClass() + "\n");
                    System.out.print(((Label)dragEvent.getGestureSource()).getParent().getClass() + "\n");
                    System.out.print(((Label)dragEvent.getSource()).getText() + "\n");
                    System.out.print(((Label)dragEvent.getTarget()).getText() + "\n");
        }
        dragEvent.consume();
        actualizarVistaDeListas();
    }

    public void dragDroppedBox(DragEvent dragEvent) { //TARGET soltas el click y terminas de arrastrar
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString()) {
                success = true;
                for (Grupal opcion : selecciones) {
                    if (opcion.texto().equals(dragEvent.getDragboard().getString())) {
                        if (dragEvent.getTarget().getClass() == VBox.class) opcion.seleccionar(((VBox) (dragEvent.getTarget())).getId());
                        else if (dragEvent.getTarget().getClass() == Label.class) opcion.seleccionar(((VBox)(((Label)dragEvent.getTarget()).getParent())).getId());
                        else opcion.seleccionar(((VBox)(((Node)dragEvent.getTarget()).getParent().getParent())).getId());
                    }
                }
        }
        dragEvent.setDropCompleted(success);

        dragEvent.consume();
    }

    public void dragOverBox(DragEvent dragEvent) { //TARGET haces que acepte un drop
        if (dragEvent.getGestureSource().getClass() == opcion1.getClass() && dragEvent.getDragboard().hasString()) {
            dragEvent.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }

        dragEvent.consume();
    }

    public void dragEnteredBox(DragEvent dragEvent) { //TARGET cuando estas arrastrando por encima del target
    }

    public void dragExitedBox(DragEvent dragEvent) { //TARGET cuando dejas de arrastrar por encima del target
    }

    public void responder(ActionEvent actionEvent) throws IOException {
        constructorDeRespuestaActual.conResponsable(jugadores.get(jugadorActual));
        constructorDeRespuestaActual.conMultiplicador( new Multiplicador(multiplicador) );
        respuestas.add(constructorDeRespuestaActual.build());
        multiplicador = 1;
        continuar();
    }

    public void activarExclusividad(ActionEvent actionEvent) {
    }

    public void activarMultiplicadorX2(ActionEvent actionEvent) {
        //       System.out.println(jugadorActual);
        if(jugadorActual == 0){
            botonMultiplicadorX2Jugador1.setVisible(false);
            botonMultiplicadorX3Jugador1.setVisible(false);
            multiplicador =2;
        }
        else {
            botonMultiplicadorX2Jugador2.setVisible(false);
            botonMultiplicadorX3Jugador2.setVisible(false);
            multiplicador = 2;
        }
    }

    public void activarMultiplicadorX3(ActionEvent actionEvent) {
        if(jugadorActual == 0){
            botonMultiplicadorX2Jugador1.setVisible(false);
            botonMultiplicadorX3Jugador1.setVisible(false);
            multiplicador = 3;
        }

        else {
            botonMultiplicadorX2Jugador2.setVisible(false);
            botonMultiplicadorX3Jugador2.setVisible(false);
            multiplicador = 3;
        }
    }
}
