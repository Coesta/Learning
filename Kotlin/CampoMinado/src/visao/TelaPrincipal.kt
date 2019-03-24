package visao

import modelo.Tabuleiro
import modelo.TabuleiroEvento
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.SwingUtilities
import javax.swing.WindowConstants

fun main() {
    TelaPrincipal()
}

class TelaPrincipal: JFrame() {
    private val tabuleiro = Tabuleiro(16,30,40)
    private val painelTabuleiro = PainelTabuleiro(tabuleiro)

    init {
        tabuleiro.onEvento(this::mostrarResultado)
        add(painelTabuleiro)

        setSize(690,438)
        setLocationRelativeTo(null)  //vai centralizar a tela no monitor
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        title = "Campo Minado"
        isVisible = true
    }

    private fun mostrarResultado(evento: TabuleiroEvento){
        SwingUtilities.invokeLater {
            val msg = when(evento) {
                TabuleiroEvento.VITORIA -> "Você ganhou!"
                TabuleiroEvento.DERROTA -> "Você perdeu... :P"
            }

            JOptionPane.showMessageDialog(this, msg)
            tabuleiro.reiniciar()

            painelTabuleiro.repaint()
            painelTabuleiro.validate()
        }
    }
}