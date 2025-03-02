package smartcity.controllers;

import smartcity.models.*;
import smartcity.models.clases.BicicletaElectrica;
import smartcity.models.clases.Sensor;
import smartcity.models.clases.Vehiculo;
import smartcity.models.factory.*;
import smartcity.view.VistaVehiculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static smartcity.models.interfaces.IEstados.*;

public class ControladorVehiculo {
    private GestionVehiculos gestionVehiculos;
    private VistaVehiculo vista;

    public ControladorVehiculo(GestionVehiculos gestionVehiculos, VistaVehiculo vista) {
        this.gestionVehiculos = gestionVehiculos;
        this.vista = vista;

        // Manejar selección de vehículo
        this.vista.agregarEventoSeleccion(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = vista.getVehiculoSeleccionado();
                CreadorVehiculo creador = obtenerCreador(tipo);
                gestionVehiculos.seleccionarVehiculo(creador);
                vista.mostrarMensaje("Vehículo seleccionado: " + tipo);
                vista.actualizarEstadoBotones(false, false);
            }
        });

        // Eventos para acciones de vehículo
        this.vista.agregarEventoEncender(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gestionVehiculos.getVehiculo() != null) {
                    gestionVehiculos.getVehiculo().encender();
                    vista.mostrarMensaje("Vehículo encendido.");
                    vista.actualizarEstadoBotones(true, false);
                    if (gestionVehiculos.getVehiculo() instanceof BicicletaElectrica)
                        vista.activarModoManual(true);


                } else {
                    vista.mostrarMensaje("Seleccione un vehículo primero.");
                }
            }
        });

        this.vista.agregarEventoApagar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gestionVehiculos.getVehiculo() != null) {
                    gestionVehiculos.getVehiculo().apagar();
                    vista.mostrarMensaje("Vehículo apagado.");
                    vista.actualizarEstadoBotones(false, false);

                } else {
                    vista.mostrarMensaje("Seleccione un vehículo primero.");
                }
            }
        });

        this.vista.agregarEventoMover(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gestionVehiculos.getVehiculo() != null) {

                    if (gestionVehiculos.getVehiculo().getBateria() < 10) {
                        vista.mostrarMensaje("Batería baja. Apagando vehiculo...");
                        gestionVehiculos.getVehiculo().apagar();
                        vista.actualizarEstadoBotones(false, false);
                    } else {
                        String estado = "";
                        if (gestionVehiculos.getVehiculo() instanceof BicicletaElectrica) {
                            if (!((BicicletaElectrica) gestionVehiculos.getVehiculo()).isModoManual()) {
                                Vehiculo vehiculo = gestionVehiculos.getVehiculo();
                                estado = vehiculo.mover();
                                System.out.println("la bicicleta esta en movimiento");
                            } else {
                                estado = gestionVehiculos.getVehiculo().mover();
                            }
                        } else {

                            estado = gestionVehiculos.getVehiculo().mover();
                        }
                        vista.mostrarMensaje(estado);
                        vista.actualizarEstadoBotones(true, true);
                    }
                } else {
                    vista.mostrarMensaje("Seleccione un vehículo primero.");
                }
            }
        });


        this.vista.agregarEventoMostrarEstado(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gestionVehiculos.getVehiculo() != null) {
                    Sensor sensor = gestionVehiculos.getVehiculo().getSensor();
                    vista.mostrarMensaje("Estado del vehículo:\n" +
                            "Velocidad: " + sensor.getVelocidad() + " km/h\n" +
                            "Batería: " + sensor.getBateria() + "%\n" +
//                            "Estado: " + (sensor.getEstado() == 1 ? "Crítico" : "Normal"));
                            "Estado: " + (estados[sensor.getEstado()]));
                } else {
                    vista.mostrarMensaje("Seleccione un vehículo primero.");
                }
            }
        });

        this.vista.agregarEventoFrenar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gestionVehiculos.getVehiculo() != null) {
                    gestionVehiculos.getVehiculo().frenar();
                    vista.mostrarMensaje("Vehículo frenado.");
                    vista.actualizarEstadoBotones(true, false);

                } else {
                    vista.mostrarMensaje("Seleccione un vehículo primero.");
                }
            }
        });

        this.vista.agregarEventoAcelerar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gestionVehiculos.getVehiculo() != null) {
                    if (gestionVehiculos.getVehiculo().getSensor().getBateria() <= 10) {
                        vista.mostrarMensaje("Batería baja. Apagando vehiculo...");
                        gestionVehiculos.getVehiculo().apagar();
                        vista.actualizarEstadoBotones(false, false);
                    } else {
                        if (gestionVehiculos.getVehiculo() instanceof BicicletaElectrica) {
                            if (!((BicicletaElectrica) gestionVehiculos.getVehiculo()).isModoManual()) {

                                Vehiculo vehiculo = gestionVehiculos.getVehiculo();
                                vehiculo.acelerar();
                                System.out.println("Modo manual desactivado");
                                vista.mostrarMensaje("Vehículo acelerado.");
                            } else {
                                gestionVehiculos.getVehiculo().acelerar();
                                vista.mostrarMensaje("Bicileta acelerada.");
                            }
                        } else {
                            gestionVehiculos.getVehiculo().acelerar();
                            vista.mostrarMensaje("Vehículo acelerado.");
                        }
                    }
                } else {
                    vista.mostrarMensaje("Seleccione un vehículo primero.");
                }
            }
        });

        this.vista.agregarEventoDesacelerar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gestionVehiculos.getVehiculo() != null) {
                    gestionVehiculos.getVehiculo().desacelerar();
                    vista.mostrarMensaje("Vehículo desacelerado.");
                } else {
                    vista.mostrarMensaje("Seleccione un vehículo primero.");
                }
            }
        });

        this.vista.agregarEventoCargarBateria(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gestionVehiculos.getVehiculo() != null) {
                    gestionVehiculos.getVehiculo().cargarBateria();
                    vista.mostrarMensaje("Batería cargada.");
                } else {
                    vista.mostrarMensaje("Seleccione un vehículo primero.");
                }
            }
        });

        this.vista.agregarEventoModoManual(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gestionVehiculos.getVehiculo() != null) {
                    if (gestionVehiculos.getVehiculo() instanceof BicicletaElectrica) {
                        vista.activarModoManual(false);
                        ((BicicletaElectrica) gestionVehiculos.getVehiculo()).setModoManual(true);
                        vista.mostrarMensaje("Modo manual activado.");
                    } else {
                        vista.mostrarMensaje("Este vehículo no tiene modo manual.");
                    }
                } else {
                    vista.mostrarMensaje("Seleccione un vehículo primero.");
                }
            }
        });

        this.vista.agregarEventoApagarManual(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gestionVehiculos.getVehiculo() != null) {
                    if (gestionVehiculos.getVehiculo() instanceof BicicletaElectrica) {
                        vista.activarModoManual(true);
                        ((BicicletaElectrica) gestionVehiculos.getVehiculo()).setModoManual(false);
                        vista.mostrarMensaje("Modo manual desactivado.");
                    } else {
                        vista.mostrarMensaje("Este vehículo no tiene modo manual.");
                    }
                } else {
                    vista.mostrarMensaje("Seleccione un vehículo primero.");
                }
            }
        });

    }

    // Método Factory Method
    private CreadorVehiculo obtenerCreador(String tipo) {
        switch (tipo) {
            case "Auto Autónomo":
                return new CreadorAutoAutonomo();
            case "Bicicleta Eléctrica":
                return new CreadorBicicletaElectrica();
            case "Transporte Autónomo":
                return new CreadorTransporteAutonomo();
            default:
                throw new IllegalArgumentException("Tipo de vehículo no válido");
        }
    }
}

