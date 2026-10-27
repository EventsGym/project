package monitorarvagas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import view.ConsultaHistorico;
import view.PresencaEvento;
import manterworkshop.manterworkshop_tela;

public class monitorarvagas_tela extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JPanel panel;

    private JTextField txtCodigo;
    private JTextField txtTitulo;
    private JTextField txtData;
    private JTextField txtVagas;
    private JTextField txtInscritos;
    private JTextField txtDisponiveis;

    private JTable tableVagas;
    private DefaultTableModel modelo;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    monitorarvagas_tela frame = new monitorarvagas_tela();

                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    frame.setVisible(true);

                    frame.centralizarFormulario();

                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        });
    }

    public monitorarvagas_tela() {

        setTitle("MONITORAR VAGAS");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 900, 550);

        contentPane = new JPanel();

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        contentPane.setLayout(null);

        panel = new JPanel();

        panel.setBounds(0, 0, 900, 550);

        contentPane.add(panel);

        panel.setLayout(null);

        JLabel lblCodigo = new JLabel("Código:");

        lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));

        lblCodigo.setBounds(135, 50, 70, 25);

        panel.add(lblCodigo);

        txtCodigo = new JTextField();

        txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));

        txtCodigo.setBounds(190, 50, 100, 25);

        panel.add(txtCodigo);

        JLabel lblTitulo = new JLabel("Título:");

        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));

        lblTitulo.setBounds(320, 50, 60, 25);

        panel.add(lblTitulo);

        txtTitulo = new JTextField();

        txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));

        txtTitulo.setBounds(362, 50, 180, 25);

        panel.add(txtTitulo);

        JLabel lblData = new JLabel("Data:");

        lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));

        lblData.setBounds(577, 50, 50, 25);

        panel.add(lblData);

        txtData = new JTextField();

        txtData.setFont(new Font("Tahoma", Font.PLAIN, 14));

        txtData.setBounds(623, 50, 120, 25);

        panel.add(txtData);

        JLabel lblVagas = new JLabel("Vagas:");

        lblVagas.setFont(new Font("Tahoma", Font.PLAIN, 14));

        lblVagas.setBounds(145, 86, 60, 25);

        panel.add(lblVagas);

        txtVagas = new JTextField();

        txtVagas.setFont(new Font("Tahoma", Font.PLAIN, 14));

        txtVagas.setBounds(190, 86, 100, 25);

        panel.add(txtVagas);

        JLabel lblInscritos = new JLabel("Inscritos:");

        lblInscritos.setFont(new Font("Tahoma", Font.PLAIN, 14));

        lblInscritos.setBounds(320, 86, 70, 25);

        panel.add(lblInscritos);

        txtInscritos = new JTextField();

        txtInscritos.setFont(new Font("Tahoma", Font.PLAIN, 14));

        txtInscritos.setBounds(379, 86, 100, 25);

        panel.add(txtInscritos);

        JLabel lblDisponiveis = new JLabel("Disponíveis:");

        lblDisponiveis.setFont(new Font("Tahoma", Font.PLAIN, 14));

        lblDisponiveis.setBounds(552, 86, 90, 25);

        panel.add(lblDisponiveis);

        txtDisponiveis = new JTextField();

        txtDisponiveis.setFont(new Font("Tahoma", Font.PLAIN, 14));

        txtDisponiveis.setBounds(630, 86, 100, 25);

        txtDisponiveis.setEditable(false);

        panel.add(txtDisponiveis);

        JButton btnAtualizar = new JButton("Atualizar");

        btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));

        btnAtualizar.setBounds(200, 148, 110, 30);

        panel.add(btnAtualizar);

        JButton btnCalcular = new JButton("Calcular");

        btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 14));

        btnCalcular.setBounds(320, 148, 110, 30);

        panel.add(btnCalcular);

        JButton btnLimpar = new JButton("Limpar");

        btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));

        btnLimpar.setBounds(440, 148, 110, 30);

        panel.add(btnLimpar);

        JButton btnWorkshop = new JButton("Workshop");

        btnWorkshop.setFont(new Font("Tahoma", Font.PLAIN, 14));

        btnWorkshop.setBounds(559, 148, 110, 30);

        panel.add(btnWorkshop);

        JButton btnPresenca = new JButton("Presença");

        btnPresenca.setFont(new Font("Tahoma", Font.PLAIN, 14));

        btnPresenca.setBounds(679, 148, 110, 30);

        panel.add(btnPresenca);

        JButton btnHistorico = new JButton("Histórico");

        btnHistorico.setFont(new Font("Tahoma", Font.PLAIN, 14));

        btnHistorico.setBounds(779, 148, 110, 30);

        panel.add(btnHistorico);

        btnWorkshop.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                manterworkshop_tela workshop = new manterworkshop_tela();

                workshop.setExtendedState(JFrame.MAXIMIZED_BOTH);

                workshop.setVisible(true);

                dispose();

            }
        });

        btnPresenca.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                PresencaEvento presenca = new PresencaEvento();

                presenca.setExtendedState(JFrame.MAXIMIZED_BOTH);

                presenca.setVisible(true);

                dispose();

            }
        });

        btnHistorico.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                ConsultaHistorico historico = new ConsultaHistorico();

                historico.setExtendedState(JFrame.MAXIMIZED_BOTH);

                historico.setVisible(true);

                dispose();

            }
        });

        modelo = new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Código",
                "Título",
                "Data",
                "Vagas",
                "Inscritos",
                "Disponíveis",
                "Status"
            }
        );

        tableVagas = new JTable(modelo);

        tableVagas.setFont(new Font("Tahoma", Font.PLAIN, 13));

        tableVagas.setRowHeight(25);

        JScrollPane scrollPane = new JScrollPane(tableVagas);

        scrollPane.setBounds(133, 209, 650, 280);

        panel.add(scrollPane);

        JLabel lblNewLabel = new JLabel("Monitorar vagas");

        lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 24));

        lblNewLabel.setBounds(349, -4, 180, 43);

        panel.add(lblNewLabel);

        addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {

                centralizarFormulario();
            }
        });

        btnCalcular.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                calcularVaga();

                adicionarVaga();
            }
        });

        btnAtualizar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                atualizarVaga();
            }
        });

        btnLimpar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                limparCampos();
            }
        });

        tableVagas.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {

                public void valueChanged(ListSelectionEvent e) {

                    int linha = tableVagas.getSelectedRow();

                    if (linha >= 0) {

                        txtCodigo.setText(
                            modelo.getValueAt(linha, 0).toString()
                        );

                        txtTitulo.setText(
                            modelo.getValueAt(linha, 1).toString()
                        );

                        txtData.setText(
                            modelo.getValueAt(linha, 2).toString()
                        );

                        txtVagas.setText(
                            modelo.getValueAt(linha, 3).toString()
                        );

                        txtInscritos.setText(
                            modelo.getValueAt(linha, 4).toString()
                        );

                        txtDisponiveis.setText(
                            modelo.getValueAt(linha, 5).toString()
                        );
                    }
                }
            }
        );
    }

    private void centralizarFormulario() {

        int x = (contentPane.getWidth() - panel.getWidth()) / 2;

        int y = (contentPane.getHeight() - panel.getHeight()) / 2;

        panel.setLocation(x, y);
    }

    private void calcularVaga() {

        try {

            int vagas = Integer.parseInt(txtVagas.getText());

            int inscritos = Integer.parseInt(txtInscritos.getText());

            int disponiveis = vagas - inscritos;

            txtDisponiveis.setText(
                String.valueOf(disponiveis)
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                this,
                "Digite números válidos em Vagas e Inscritos."
            );
        }
    }

    private void adicionarVaga() {

        try {

            int vagas = Integer.parseInt(txtVagas.getText());

            int inscritos = Integer.parseInt(txtInscritos.getText());

            int disponiveis = vagas - inscritos;

            String status;

            if (disponiveis <= 0) {

                status = "LOTADO";

            } else {

                status = "DISPONÍVEL";
            }

            modelo.addRow(new Object[] {
                txtCodigo.getText(),
                txtTitulo.getText(),
                txtData.getText(),
                vagas,
                inscritos,
                disponiveis,
                status
            });

        } catch (NumberFormatException e) {

            // Não adiciona nada se os valores forem inválidos.
        }
    }

    private void atualizarVaga() {

        int linha = tableVagas.getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(
                this,
                "Selecione uma vaga na tabela."
            );

            return;
        }

        try {

            int vagas = Integer.parseInt(txtVagas.getText());

            int inscritos = Integer.parseInt(txtInscritos.getText());

            int disponiveis = vagas - inscritos;

            String status;

            if (disponiveis <= 0) {

                status = "LOTADO";

            } else {

                status = "DISPONÍVEL";
            }

            modelo.setValueAt(
                txtCodigo.getText(),
                linha,
                0
            );

            modelo.setValueAt(
                txtTitulo.getText(),
                linha,
                1
            );

            modelo.setValueAt(
                txtData.getText(),
                linha,
                2
            );

            modelo.setValueAt(
                vagas,
                linha,
                3
            );

            modelo.setValueAt(
                inscritos,
                linha,
                4
            );

            modelo.setValueAt(
                disponiveis,
                linha,
                5
            );

            modelo.setValueAt(
                status,
                linha,
                6
            );

            txtDisponiveis.setText(
                String.valueOf(disponiveis)
            );

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                this,
                "Digite números válidos em Vagas e Inscritos."
            );
        }
    }

    private void limparCampos() {

        txtCodigo.setText("");

        txtTitulo.setText("");

        txtData.setText("");

        txtVagas.setText("");

        txtInscritos.setText("");

        txtDisponiveis.setText("");

        tableVagas.clearSelection();
    }
}
