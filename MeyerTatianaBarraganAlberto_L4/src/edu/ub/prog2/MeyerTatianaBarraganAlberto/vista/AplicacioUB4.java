/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.MeyerTatianaBarraganAlberto.vista;
import edu.ub.prog2.MeyerTatianaBarraganAlberto.controlador.Controlador;
import edu.ub.prog2.utils.AplicacioException;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;


/**
 *
 * @author dragr
 */
public class AplicacioUB4 extends javax.swing.JFrame {
    protected static final ImageIcon GUT_IMG = new ImageIcon(AplicacioUB4.class.getResource("/assets/DDS_Small.png"));
    protected static final ImageIcon ERROR_IMG = new ImageIcon(AplicacioUB4.class.getResource("/assets/DDS_Small.png"));
    protected static final ImageIcon WARNING_IMG = new ImageIcon(AplicacioUB4.class.getResource("/assets/DDS_Small.png"));
    private final Controlador ctrl;
    /**
     * AplicacioUB4
     */
    public AplicacioUB4() {
        this.ctrl = Controlador.getInstance();
        initComponents();
        this.setTitle("Reproductor Multimedia");
    }

    /**
     * Código generado de JFrame, inicializa el formulario de JFrame.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optCreditos = new javax.swing.JButton();
        mediaButtons = new javax.swing.JPanel();
        optNext = new javax.swing.JButton();
        optPlay = new javax.swing.JButton();
        optPause = new javax.swing.JButton();
        optStop = new javax.swing.JButton();
        jScrollBib = new javax.swing.JScrollPane();
        lstBib = new javax.swing.JList<String>();
        optDeleteBib = new javax.swing.JButton();
        optAddBib = new javax.swing.JButton();
        optRepBiblio = new javax.swing.JButton();
        optRepFich = new javax.swing.JButton();
        bibLabel = new javax.swing.JLabel();
        jScrollAlbum = new javax.swing.JScrollPane();
        lstAlbum = new javax.swing.JList<String>();
        albumLabel = new javax.swing.JLabel();
        optAddAlb = new javax.swing.JButton();
        optDeleteAlb = new javax.swing.JButton();
        optRepFichAlb = new javax.swing.JButton();
        cmbAlbumes = new javax.swing.JComboBox();
        albumesLabel = new javax.swing.JLabel();
        optDeleteAlbum = new javax.swing.JButton();
        optCrearAlbum = new javax.swing.JButton();
        optReproAlbum = new javax.swing.JButton();
        menuBase = new javax.swing.JMenuBar();
        mFicheros = new javax.swing.JMenu();
        Cargar = new javax.swing.JMenuItem();
        Guardar = new javax.swing.JMenuItem();
        mOpciones = new javax.swing.JMenu();
        mReproductor = new javax.swing.JMenu();
        optAleatoria = new javax.swing.JCheckBoxMenuItem();
        optBucle = new javax.swing.JCheckBoxMenuItem();
        optSalir = new javax.swing.JMenuItem();
        mBiblioteca = new javax.swing.JMenu();
        optAddFichero = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        optCreditos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/DDS_Small.png"))); // NOI18N
        optCreditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optCreditosActionPerformed(evt);
            }
        });

        optNext.setText("Next");
        optNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optNextActionPerformed(evt);
            }
        });

        optPlay.setText("Play");
        optPlay.setMaximumSize(new java.awt.Dimension(66, 32));
        optPlay.setMinimumSize(new java.awt.Dimension(66, 32));
        optPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optPlayActionPerformed(evt);
            }
        });

        optPause.setText("Pause");
        optPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optPauseActionPerformed(evt);
            }
        });

        optStop.setText("Stop");
        optStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optStopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mediaButtonsLayout = new javax.swing.GroupLayout(mediaButtons);
        mediaButtons.setLayout(mediaButtonsLayout);
        mediaButtonsLayout.setHorizontalGroup(
            mediaButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mediaButtonsLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(optStop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optPause)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optPlay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optNext)
                .addGap(35, 35, 35))
        );
        mediaButtonsLayout.setVerticalGroup(
            mediaButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mediaButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mediaButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(optPlay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(optNext)
                    .addComponent(optPause)
                    .addComponent(optStop))
                .addGap(26, 26, 26))
        );

        lstBib.setModel(makeListModel(new ArrayList<>()));
        lstBib.setFocusable(false);
        lstBib.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstBibMouseClicked(evt);
            }
        });
        jScrollBib.setViewportView(lstBib);

        optDeleteBib.setText("Borrar");
        optDeleteBib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDeleteBibActionPerformed(evt);
            }
        });

        optAddBib.setText("Añadir");
        optAddBib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optAddBibActionPerformed(evt);
            }
        });

        optRepBiblio.setText("Rep. Biblio.");
        optRepBiblio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optRepBiblioActionPerformed(evt);
            }
        });

        optRepFich.setText("Rep. Fichero");
        optRepFich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optRepFichActionPerformed(evt);
            }
        });

        bibLabel.setText("Biblioteca");

        lstAlbum.setModel(makeListModel(new ArrayList<>()));
        lstBib.setFocusable(false);
        lstBib.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstBibMouseClicked(evt);
            }
        });
        jScrollAlbum.setViewportView(lstAlbum);

        albumLabel.setText("Álbum");

        optAddAlb.setText("Añadir");
        optAddAlb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optAddAlbActionPerformed(evt);
            }
        });

        optDeleteAlb.setText("Borrar");
        optDeleteAlb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDeleteAlbActionPerformed(evt);
            }
        });

        optRepFichAlb.setText("Rep. Fich.");
        optRepFichAlb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optRepFichAlbActionPerformed(evt);
            }
        });

        cmbAlbumes.setModel(new DefaultComboBoxModel<>());
        cmbAlbumes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAlbumesActionPerformed(evt);
            }
        });

        albumesLabel.setText("Álbumes");

        optDeleteAlbum.setText("Eliminar");
        optDeleteAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optDeleteAlbumActionPerformed(evt);
            }
        });

        optCrearAlbum.setText("Crear");
        optCrearAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optCrearAlbumActionPerformed(evt);
            }
        });

        optReproAlbum.setText("Reproducir");
        optReproAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optReproAlbumActionPerformed(evt);
            }
        });

        mFicheros.setText("Ficheros");

        Cargar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        Cargar.setText("Abrir");
        Cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarActionPerformed(evt);
            }
        });
        mFicheros.add(Cargar);

        Guardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        mFicheros.add(Guardar);

        menuBase.add(mFicheros);

        mOpciones.setText("Opciones");

        mReproductor.setText("Reproductor");

        optAleatoria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        optAleatoria.setSelected(false);
        optAleatoria.setText("Aleatoria");
        optAleatoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optAleatoriaActionPerformed(evt);
            }
        });
        mReproductor.add(optAleatoria);

        optBucle.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        optBucle.setSelected(false);
        optBucle.setText("Bucle");
        optBucle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optBucleActionPerformed(evt);
            }
        });
        mReproductor.add(optBucle);

        mOpciones.add(mReproductor);

        optSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        optSalir.setText("Salir");
        optSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optSalirActionPerformed(evt);
            }
        });
        mOpciones.add(optSalir);

        menuBase.add(mOpciones);

        mBiblioteca.setText("Biblioteca");

        optAddFichero.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        optAddFichero.setText("Añadir fichero");
        optAddFichero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optAddFicheroActionPerformed(evt);
            }
        });
        mBiblioteca.add(optAddFichero);

        menuBase.add(mBiblioteca);

        setJMenuBar(menuBase);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(bibLabel)
                .addGap(239, 239, 239)
                .addComponent(albumesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(albumLabel)
                .addGap(88, 88, 88))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(optDeleteBib, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(optRepBiblio, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(optAddBib, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(optRepFich, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 410, Short.MAX_VALUE)
                                .addComponent(optAddAlb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(optDeleteAlb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(mediaButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(optCreditos, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(optRepFichAlb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollBib, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(cmbAlbumes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(optCrearAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(optDeleteAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(optReproAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bibLabel)
                    .addComponent(albumLabel)
                    .addComponent(albumesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(optAddAlb)
                            .addComponent(optDeleteAlb))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(optRepFichAlb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(optCreditos))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollBib, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(optDeleteBib)
                            .addComponent(optAddBib))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(optRepBiblio)
                            .addComponent(optRepFich))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbAlbumes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(optCrearAlbum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(optDeleteAlbum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(optReproAlbum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mediaButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
                File file;
        String path;
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            path = file.getPath();
            try {
                ctrl.guardarDadesDisc(path);
                refreshAll();
                JOptionPane.showMessageDialog(this, "Datos guardados correctamente", "Datos guardados", JOptionPane.PLAIN_MESSAGE, GUT_IMG);
            } catch (AplicacioException ex){
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
            }
        }
    }//GEN-LAST:event_GuardarActionPerformed

    private void optSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_optSalirActionPerformed
    
    /**
     * Acción de carga de datos, abre un JFileChooser.
     * @param evt 
     */
    private void CargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarActionPerformed
        File file;
        String path;
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            path = file.getPath();
            try {
                ctrl.carregarDadesDisc(path);
                refreshAll();
                JOptionPane.showMessageDialog(this, "Datos cargados correctamente", "Datos cargados", JOptionPane.PLAIN_MESSAGE, GUT_IMG);
            } catch (AplicacioException ex){
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
            }
        }
    }//GEN-LAST:event_CargarActionPerformed

    private void optPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optPlayActionPerformed
        try{
            ctrl.reemprenReproduccio();
        } catch (AplicacioException ex){
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
        }
    }//GEN-LAST:event_optPlayActionPerformed

    private void optCreditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optCreditosActionPerformed
        frmCreditos panel = new frmCreditos(this, true);
        panel.setVisible(true);
    }//GEN-LAST:event_optCreditosActionPerformed

    private void optAddFicheroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optAddFicheroActionPerformed
        frmAddFichero panel = new frmAddFichero(this, true);
        panel.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent ev){
                if(panel.isAdded()){
                    refreshBiblioteca();
                }
        }
        });
        panel.setVisible(true);
    }//GEN-LAST:event_optAddFicheroActionPerformed

    private void optAddBibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optAddBibActionPerformed
        optAddFicheroActionPerformed(evt);
    }//GEN-LAST:event_optAddBibActionPerformed
    
    /**
     * Elimina ficheros de la lista de la biblioteca.
     * @param evt 
     */
    private void optDeleteBibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDeleteBibActionPerformed
        int[] indices = this.lstBib.getSelectedIndices();
        if (indices.length > 0) {
            try {
                int eliminados = 0;
                for (int i : indices) {
                    ctrl.esborrarFitxer(i - eliminados);
                    eliminados++;
                }
                refreshBiblioteca();
                refreshAlbumes();
                refreshAlbum();
                JOptionPane.showMessageDialog(this, "Fichero/s eliminado/s.", "Eliminador de ficheros", JOptionPane.PLAIN_MESSAGE, GUT_IMG);
            } catch (AplicacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona uno o varios ficheros antes", "Avis", JOptionPane.PLAIN_MESSAGE, WARNING_IMG);
        }   
    }//GEN-LAST:event_optDeleteBibActionPerformed

    private void optRepFichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optRepFichActionPerformed
        int index = this.lstBib.getSelectedIndex();
        try {
            ctrl.reproduirFitxer(index);
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
        }
    }//GEN-LAST:event_optRepFichActionPerformed

    private void optAddAlbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optAddAlbActionPerformed
        int[] indices = this.lstBib.getSelectedIndices();
        int indexAlbum = this.cmbAlbumes.getSelectedIndex();
        int afegits = 0;
        String messageFinestra, titolFinestra;
        ImageIcon tipusFinestra;

        if (indices.length > 0) {
            try {
                String titol = ctrl.getTitolAlbum(indexAlbum);
                for (int i : indices) {
                    ctrl.afegirFitxer(titol, i);
                    afegits++;
                }
                messageFinestra = "Fichero/s añadido/s al álbum.";
                titolFinestra = "Fichero/s añadido/s al álbum.";
                tipusFinestra = GUT_IMG;
            } catch (AplicacioException ex) {
                messageFinestra = ex.getMessage() + ", ficheros añadidos: " + afegits;
                titolFinestra = "Error";
                tipusFinestra = ERROR_IMG;
            }
            if (afegits >= 1) {
                refreshAlbum();
                refreshAlbumes();
            }
            JOptionPane.showMessageDialog(this, messageFinestra, titolFinestra, JOptionPane.PLAIN_MESSAGE, tipusFinestra);
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona uno o varios ficheros antes.", "Aviso", JOptionPane.PLAIN_MESSAGE, WARNING_IMG);
        }
    }//GEN-LAST:event_optAddAlbActionPerformed

    private void optDeleteAlbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDeleteAlbActionPerformed
        int[] indices = this.lstAlbum.getSelectedIndices();
        int indexAlbum = this.cmbAlbumes.getSelectedIndex();

        if (indices.length > 0) {
            try {
                int eliminados = 0;
                String titol = ctrl.getTitolAlbum(indexAlbum);
                for (int i : indices) {
                    ctrl.esborrarFitxer(titol, i - eliminados);
                    eliminados++;
                }
                refreshAlbum();
                refreshAlbumes();
                JOptionPane.showMessageDialog(this, "Fichero/s eliminado/s del álbum.", "Eliminador de fihceros de álbum", JOptionPane.PLAIN_MESSAGE, GUT_IMG);
            } catch (AplicacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona uno o varios ficheros antes.", "Aviso", JOptionPane.PLAIN_MESSAGE, WARNING_IMG);
        }
    }//GEN-LAST:event_optDeleteAlbActionPerformed

    private void cmbAlbumesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAlbumesActionPerformed
        refreshAlbum();
    }//GEN-LAST:event_cmbAlbumesActionPerformed

    private void optDeleteAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optDeleteAlbumActionPerformed
        int index = this.cmbAlbumes.getSelectedIndex();

        try {
            String titol = ctrl.getTitolAlbum(index);
            ctrl.esborrarAlbum(titol);
            refreshAlbumes();
            refreshAlbum();
            JOptionPane.showMessageDialog(this, "Álbum " + titol + " borrado correctamente.", "Eliminador de álbumes", JOptionPane.PLAIN_MESSAGE, GUT_IMG);
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
        }
    }//GEN-LAST:event_optDeleteAlbumActionPerformed

    private void optCrearAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optCrearAlbumActionPerformed
        String titol = JOptionPane.showInputDialog(this, "Introduce el nombre del álbum.", "Crear Álbum - Nombre", JOptionPane.PLAIN_MESSAGE);
        if (titol != null) {
            int capacitatFinal;
            String capacitat = JOptionPane.showInputDialog(this, "Introduce la capacidad del álbum", "Crear Álbum - Capacidad", JOptionPane.PLAIN_MESSAGE);
            if (capacitat != null) {
                String messageCapacitat = "";
                String message;
                ImageIcon tipus = GUT_IMG;
                try {
                    capacitatFinal = Integer.parseInt(capacitat);
                } catch (HeadlessException | NumberFormatException ex) {
                    messageCapacitat = "capacitat no valida, assignada 10 per defecte";
                    capacitatFinal = 10;
                }

                try {
                    ctrl.addAlbum(titol, capacitatFinal);
                    refreshAlbumes();
                    message = "Álbum " + titol + " creado";
                    if (!messageCapacitat.isEmpty()) {
                        message += "\n" + messageCapacitat;
                        tipus = WARNING_IMG;
                    }
                    JOptionPane.showMessageDialog(this, message, "Álbum creado", JOptionPane.PLAIN_MESSAGE, tipus);
                } catch (AplicacioException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
                }
            }
        }
    }//GEN-LAST:event_optCrearAlbumActionPerformed

    private void optReproAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optReproAlbumActionPerformed
        int indexAlbum = this.cmbAlbumes.getSelectedIndex();
        try {
            String titol = ctrl.getTitolAlbum(indexAlbum);
            ctrl.reproduirCarpeta(titol);
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
        }
    }//GEN-LAST:event_optReproAlbumActionPerformed

    private void optRepBiblioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optRepBiblioActionPerformed
        try{
        ctrl.reproduirCarpeta();
        } catch (AplicacioException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
        }
    }//GEN-LAST:event_optRepBiblioActionPerformed

    private void optBucleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optBucleActionPerformed
        ctrl.toggleLoop();
    }//GEN-LAST:event_optBucleActionPerformed

    private void optAleatoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optAleatoriaActionPerformed
        ctrl.toggleRandom();
    }//GEN-LAST:event_optAleatoriaActionPerformed

    private void optRepFichAlbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optRepFichAlbActionPerformed
        int index = this.lstAlbum.getSelectedIndex();
        int indexAlbum = this.cmbAlbumes.getSelectedIndex();

        try {
            String titol = ctrl.getTitolAlbum(indexAlbum);
            ctrl.reproduirFitxer(index, titol);
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
        }
    }//GEN-LAST:event_optRepFichAlbActionPerformed

    private void optStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optStopActionPerformed
        try{
            ctrl.aturaReproduccio();
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
        }
    }//GEN-LAST:event_optStopActionPerformed

    private void optPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optPauseActionPerformed
        try{
            ctrl.pausaReproduccio();
        } catch (AplicacioException ex){
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
        }
    }//GEN-LAST:event_optPauseActionPerformed

    private void optNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optNextActionPerformed
        try{
            ctrl.saltaReproduccio();
        }catch (AplicacioException ex){
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
        }
    }//GEN-LAST:event_optNextActionPerformed

     /**
     * Evento de click en un elemento del JList, para mostrar información de un
     * fichero de la biblioteca
     *
     * @param evt
     */
    private void lstBibMouseClicked(java.awt.event.MouseEvent evt) {                                           
        JList list = (JList) evt.getSource();
        int index = list.locationToIndex(evt.getPoint());
        if (evt.getClickCount() == 2 && index >= 0) {
            JOptionPane.showMessageDialog(this, ctrl.infoFitxer(index), "Información del fichero", JOptionPane.PLAIN_MESSAGE);
        }
    }     
    
     /**
     * Hace y retorna un nuevo ListModel<String> para asociarselo a un Jlist
     *
     * @param list
     * @return ListModel<String>
     */
    private ListModel<String> makeListModel(List<String> list) {
        return new AbstractListModel<String>() {
            String[] strings = list.toArray(new String[list.size()]);

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public String getElementAt(int i) {
                return strings[i];
            }
        };
    }
    
    /**
     * Refresca la vista entera
     */
    private void refreshAll(){
        refreshBiblioteca();
        refreshAlbumes();
        refreshAlbum();
        this.optBucle.setSelected(ctrl.isReproduccionBucle());
        this.optAleatoria.setSelected(ctrl.isReproduccionAleatoria());
    }
    
    
    
    /**
     * Actualizar biblioteca al salir de la pestaña de añadir fichero.
     */
    private void refreshBiblioteca(){
        List<String> bibList = ctrl.mostrarBiblioteca();
        int[] indices = lstBib.getSelectedIndices();
        this.lstBib.setModel(makeListModel(bibList));
        this.lstBib.setSelectedIndices(indices);
    }
    
    
    
    
    /**
     * Refresca el JList del album
     */
    private void refreshAlbum() {
        int index = this.cmbAlbumes.getSelectedIndex();
        int size = cmbAlbumes.getModel().getSize();
        boolean updateAlbum = (size > 0 && index < size);
        if (updateAlbum) {
            try {
                String titol = ctrl.getTitolAlbum(index);
                List<String> albumList = ctrl.mostrarAlbum(titol);
                int[] indices = lstAlbum.getSelectedIndices();
                lstAlbum.setModel(makeListModel(albumList));
                lstAlbum.setSelectedIndices(indices);
            } catch (AplicacioException ex) {
                lstAlbum.setModel(makeListModel(new ArrayList<>()));
            }
        }
    }
    
    
    /**
     * Refresca el JComboBox de albums
     */
    private void refreshAlbumes() {
        List<String> albumsList = ctrl.mostrarLlistatAlbums();
        int index = cmbAlbumes.getSelectedIndex();
        String[] strings = albumsList.toArray(new String[albumsList.size()]);
        cmbAlbumes.setModel(new DefaultComboBoxModel<>(strings));
        int modelSize = cmbAlbumes.getModel().getSize();

        if (modelSize > 0) {
            if (index == -1) {
                index++;
            } else if (index > modelSize - 1) {
                index--;
            }
            cmbAlbumes.setSelectedIndex(index);
        }
    }
    
    
    /**
     * Oculta los botones de media.
     */
    private void hideMediaButtons(){
        mediaButtons.setVisible(false);
    }
    /**
     * Muestra los botones de media.
     */
    private void showMediaButtons(){
        mediaButtons.setVisible(true);
    }
    
    private void repOpen(){
        showMediaButtons();
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AplicacioUB4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AplicacioUB4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AplicacioUB4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AplicacioUB4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AplicacioUB4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Cargar;
    private javax.swing.JMenuItem Guardar;
    private javax.swing.JLabel albumLabel;
    private javax.swing.JLabel albumesLabel;
    private javax.swing.JLabel bibLabel;
    private javax.swing.JComboBox cmbAlbumes;
    private javax.swing.JScrollPane jScrollAlbum;
    private javax.swing.JScrollPane jScrollBib;
    private javax.swing.JList lstAlbum;
    private javax.swing.JList lstBib;
    private javax.swing.JMenu mBiblioteca;
    private javax.swing.JMenu mFicheros;
    private javax.swing.JMenu mOpciones;
    private javax.swing.JMenu mReproductor;
    private javax.swing.JPanel mediaButtons;
    private javax.swing.JMenuBar menuBase;
    private javax.swing.JButton optAddAlb;
    private javax.swing.JButton optAddBib;
    private javax.swing.JMenuItem optAddFichero;
    private javax.swing.JCheckBoxMenuItem optAleatoria;
    private javax.swing.JCheckBoxMenuItem optBucle;
    private javax.swing.JButton optCrearAlbum;
    private javax.swing.JButton optCreditos;
    private javax.swing.JButton optDeleteAlb;
    private javax.swing.JButton optDeleteAlbum;
    private javax.swing.JButton optDeleteBib;
    private javax.swing.JButton optNext;
    private javax.swing.JButton optPause;
    private javax.swing.JButton optPlay;
    private javax.swing.JButton optRepBiblio;
    private javax.swing.JButton optRepFich;
    private javax.swing.JButton optRepFichAlb;
    private javax.swing.JButton optReproAlbum;
    private javax.swing.JMenuItem optSalir;
    private javax.swing.JButton optStop;
    // End of variables declaration//GEN-END:variables
}
