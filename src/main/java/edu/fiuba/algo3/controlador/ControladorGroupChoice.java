package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.opciones.Grupal;
import edu.fiuba.algo3.modelo.preguntas.GroupChoice;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public class ControladorGroupChoice extends ControladorPregunta{
    public Label nombreGrupoA, nombreGrupoB;
    public Label opcion1,opcion2,opcion3,opcion4,opcion5,opcion6;
    public VBox BoxGrupoB,BoxGrupoA,BoxSinGrupo;
    private List<Grupal> opciones;
    public List<Label> labelsOpciones = new ArrayList<>();
    public List<Label> labelsGrupos = new ArrayList<>();
    public List<VBox> boxGrupos = new ArrayList<>();
    public Hashtable<String,VBox> mapaDeGrupos = new Hashtable<>();

    public void initialize() {
        cargarBotones();
        inicializarLabelsPregunta();
        ajustarLabel(enunciadoPregunta);
        opciones = ((GroupChoice)preguntaActual).obtenerOpciones();
        Collections.shuffle(opciones);
        constructorDeRespuestaActual.conResponsable(jugadores.get(jugadorActual));
        labelsGrupos.add(nombreGrupoA);
        labelsGrupos.add(nombreGrupoB);
        labelsOpciones.add(opcion1);
        labelsOpciones.add(opcion2);
        labelsOpciones.add(opcion3);
        labelsOpciones.add(opcion4);
        labelsOpciones.add(opcion5);
        labelsOpciones.add(opcion6);
        boxGrupos.add(BoxSinGrupo);
        boxGrupos.add(BoxGrupoA);
        boxGrupos.add(BoxGrupoB);
        int i=0,j=0;
        mapaDeGrupos.put("sinGrupo", boxGrupos.get(j++));
        boxGrupos.get(j).setId("sinGrupo");
        for (Grupal opcion : opciones){
            labelsOpciones.get(i).setText(opcion.texto());
            if(!mapaDeGrupos.containsKey(opcion.grupo())){
                mapaDeGrupos.put(opcion.grupo(), boxGrupos.get(j));
                labelsGrupos.get(j-1).setText(opcion.grupo());
                boxGrupos.get(j).setId(opcion.grupo());
                j++;
            }
            i++;
        }
        BoxSinGrupo.getChildren().remove(i,labelsOpciones.size());
        iniciarTemporizador();
    }

    private void actualizarVistaDeListas(){
        for (Grupal opcion : opciones){
            if (!mapaDeGrupos.get(opcion.grupoSeleccionado()).getChildren().contains(labelsOpciones.get(opciones.indexOf(opcion)))){
                mapaDeGrupos.get(opcion.grupoSeleccionado()).getChildren().add(labelsOpciones.get(opciones.indexOf(opcion)));
            }
        }
    }

    public void dragDetectedOpcion(MouseEvent mouseEvent) { //SOURCE - Se detecta que comenzo a arrastrarse el label
        Dragboard db = ((Label)mouseEvent.getSource()).startDragAndDrop(TransferMode.ANY);
        ClipboardContent content = new ClipboardContent();
        content.putString(((Label)mouseEvent.getSource()).getText());
        db.setContent(content);
        mouseEvent.consume();
    }

    public void dragDroppedBox(DragEvent dragEvent) { //TARGET - Se detecta que se solto la opcion sobre el VBox objetvo
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            success = true;
            for (Grupal opcion : opciones) {
                if (opcion.texto().equals(dragEvent.getDragboard().getString())) { //El else-if busca si es que uno esta dropeando sobre el objetivo o uno de sus hijos
                    if (dragEvent.getTarget().getClass() == VBox.class) opcion.seleccionar(((VBox) (dragEvent.getTarget())).getId());
                    else if (dragEvent.getTarget().getClass() == Label.class) opcion.seleccionar(((VBox)(((Label)dragEvent.getTarget()).getParent())).getId());
                    else opcion.seleccionar(((VBox)(((Node)dragEvent.getTarget()).getParent().getParent())).getId());
                }
            }
        }
        dragEvent.setDropCompleted(success);
        actualizarVistaDeListas();
        dragEvent.consume();
    }

    public void dragOverBox(DragEvent dragEvent) { //TARGET - Si lo que se arrastra sobre el VBox objetivo es un Label, se acepta el drop
        if (dragEvent.getGestureSource().getClass() == Label.class && dragEvent.getDragboard().hasString()) {
            dragEvent.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }
        dragEvent.consume();
    }

    public void dragEnteredBox(DragEvent dragEvent) { //TARGET - Ayuda visual: Cuando se esta arrastrando sobre el objetivo cambia de color
        ((VBox)dragEvent.getTarget()).setStyle("-fx-background-color: #43B581; -fx-background-radius: 20 20 20 20");
    }

    public void dragExitedBox(DragEvent dragEvent) { //TARGET - Ayuda visual: Cuando se sale del objetivo, este cambia de color
        ((VBox)dragEvent.getTarget()).setStyle("-fx-background-color: #69C49A; -fx-background-radius: 20 20 20 20");
    }

    public void responder(ActionEvent actionEvent) throws IOException {
        accionExclusividad();
        constructorDeRespuestaActual.conSelecciones(List.copyOf(opciones));
        respuestas.add(constructorDeRespuestaActual.build());
        continuar();
    }
}
