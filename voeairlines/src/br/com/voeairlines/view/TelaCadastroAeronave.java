package br.com.voeairlines.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.voeairlines.controller.AeronaveController;
import br.com.voeairlines.controller.TipoAeronaveController;
import br.com.voeairlines.controller.UsuarioController;
import br.com.voeairlines.dao.ExceptionDAO;
import br.com.voeairlines.model.TipoAeronave;
import br.com.voeairlines.model.Usuario;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastroAeronave extends JFrame {

	private JPanel contentPaneCadastroAeronave;
	private JTextField txtFabricante;
	private JTextField txtModelo;
	private JTextField txtCodigo;
	private JComboBox<TipoAeronave> cbIdTipo;
	private Integer idAeronave = 0;

	public TelaCadastroAeronave() {
		setVisible(true);
		initComponents();
	}

	public void buscarAeronave(Integer idAeronave, String fabricante, String modelo, String codigo) {
		this.idAeronave  = idAeronave;
		this.txtFabricante.setText(fabricante);
		this.txtModelo.setText(modelo);
		this.txtCodigo.setText(codigo);
	}
	/**
	 * Create the frame.
	 */
	public void initComponents() {
		setTitle("VoeAirlines Cadastro");
		setBounds(100, 100, 565, 271);
		setLocationRelativeTo(null);
		contentPaneCadastroAeronave = new JPanel();
		contentPaneCadastroAeronave.setBackground(new Color(192, 192, 192));
		contentPaneCadastroAeronave.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneCadastroAeronave);
		contentPaneCadastroAeronave.setLayout(null);

		JLabel lblCadastroAeronave = new JLabel("Cadastro Aeronave");
		lblCadastroAeronave.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCadastroAeronave.setBounds(172, 11, 155, 14);
		contentPaneCadastroAeronave.add(lblCadastroAeronave);

		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFabricante.setBounds(10, 43, 85, 24);
		contentPaneCadastroAeronave.add(lblFabricante);

		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblModelo.setBounds(10, 78, 85, 24);
		contentPaneCadastroAeronave.add(lblModelo);

		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 113, 85, 24);
		contentPaneCadastroAeronave.add(lblNewLabel);

		txtFabricante = new JTextField();
		txtFabricante.setToolTipText("Fabricante");
		txtFabricante.setBounds(105, 47, 251, 20);
		contentPaneCadastroAeronave.add(txtFabricante);
		txtFabricante.setColumns(10);

		txtModelo = new JTextField();
		txtModelo.setToolTipText("Modelo");
		txtModelo.setColumns(10);
		txtModelo.setBounds(105, 82, 251, 20);
		contentPaneCadastroAeronave.add(txtModelo);

		txtCodigo = new JTextField();
		txtCodigo.setToolTipText("Código");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(105, 117, 251, 20);
		contentPaneCadastroAeronave.add(txtCodigo);

		JComboBox<TipoAeronave> cbIdTipo = new JComboBox<TipoAeronave>();
		try {
			TipoAeronaveController tpAeroC = new TipoAeronaveController();
			Vector<TipoAeronave> descricoes;
			descricoes = tpAeroC.listarDescricao();
			cbIdTipo.setModel(new DefaultComboBoxModel<TipoAeronave>(descricoes));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		cbIdTipo.setBounds(105, 151, 155, 22);
		contentPaneCadastroAeronave.add(cbIdTipo);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TipoAeronaveController tpAeroC = new TipoAeronaveController();
				Vector<TipoAeronave> descricoes = null;
				try {
					descricoes = tpAeroC.listarDescricao();
				} catch (ExceptionDAO e1) {
					e1.printStackTrace();
				}
				try {
					if (txtFabricante.getText().equals("") && txtModelo.getText().equals("")
							&& txtCodigo.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Os campos não foram preenchidos corretamente.");
					} else {
						descricoes = tpAeroC.listarDescricao();
						AeronaveController aeronaveController = new AeronaveController();
						aeronaveController.cadastrarAeronave(txtFabricante.getText(), txtModelo.getText(),
								txtCodigo.getText(), descricoes.get(cbIdTipo.getSelectedIndex()));
						JOptionPane.showMessageDialog(null, "Cadastro Realizado com sucesso!");
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Erro:" + ex);
				}
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCadastrar.setBounds(400, 46, 120, 23);
		contentPaneCadastroAeronave.add(btnCadastrar);

		JLabel lblTipoDaAeronave = new JLabel("Tipo: ");
		lblTipoDaAeronave.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTipoDaAeronave.setBounds(10, 148, 42, 24);
		contentPaneCadastroAeronave.add(lblTipoDaAeronave);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean sucesso;
				TipoAeronaveController tpAeroC = new TipoAeronaveController();
				Vector<TipoAeronave> descricoes = null;
				try {
					descricoes = tpAeroC.listarDescricao();
				} catch (ExceptionDAO e1) {
					e1.printStackTrace();
				}
				try {
					AeronaveController aeronaveController = new AeronaveController();
					sucesso = aeronaveController.alterarAeronave(idAeronave, txtFabricante.getText(), txtModelo.getText(), txtCodigo.getText(),descricoes.get(cbIdTipo.getSelectedIndex()) );

					if (sucesso == true) {
						JOptionPane.showMessageDialog(null, "O cadastro foi alterado com sucesso");
						txtFabricante.setText("");
						txtModelo.setText("");
						txtCodigo.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Os campos não estão preenchidos corretamente.");
					}
				} catch (Exception e2) {

				}
			}
		});
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAlterar.setBounds(400, 81, 120, 23);
		contentPaneCadastroAeronave.add(btnAlterar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaConsultaAeronave telaConsultaAeronave = new TelaConsultaAeronave();
				telaConsultaAeronave.setVisible(true);
				setVisible(false);
			}
		});
		btnConsultar.setBounds(400, 116, 120, 23);
		contentPaneCadastroAeronave.add(btnConsultar);

		JButton btnApagar = new JButton("Apagar");
		btnApagar.setBorder(new LineBorder(new Color(204, 0, 0)));
		btnApagar.setForeground(new Color(255, 145, 138));
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean sucesso;
				String message = "Deseja realmente apagar a aeronave?";
				String title = "Confirmação";
				// Exibe caixa de dialogo (veja figura) solicitando confirmação ou não.
				// Se o usuário clicar em "Sim" retorna 0 pra variavel reply, se informado não
				// retorna 1
				int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					try {
						AeronaveController aeronaveController = new AeronaveController();
						sucesso = aeronaveController.apagarAeronave(idAeronave);

						if (sucesso == true) {
							JOptionPane.showMessageDialog(null, "O usuario foi apagado com sucesso");
							txtFabricante.setText("");
							txtModelo.setText("");
							txtCodigo.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "Os campos não estão preenchidos corretamente.");
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		});
		btnApagar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnApagar.setBounds(400, 151, 120, 23);
		contentPaneCadastroAeronave.add(btnApagar);
	}
}
