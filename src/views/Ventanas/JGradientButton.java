package views.Ventanas;

import javax.swing.*;
import java.awt.*;
    /**
     * Clase para crear JButtons con un color de gradiente
     *
     * @author Gabriela MP
     */
    public class JGradientButton extends JButton {

        public JGradientButton() {
            setContentAreaFilled(false);
        }

        /**
         * Metodo que crea y pinta el gradiente de los botones
         *
         * @param g
         */
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setPaint(new GradientPaint(
                    new Point(0, 0),
                    Color.WHITE,
                    new Point(0, getHeight()),
                    new Color(210, 169, 255)));
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.dispose();

            super.paintComponent(g);
        }
    }
