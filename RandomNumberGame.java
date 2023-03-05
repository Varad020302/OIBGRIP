import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandomNumberGame{
  private Random rand = new Random();
  private int Guess = rand.nextInt(100) + 1;
  private int numberOfTries = 0;

  public RandomNumberGame() {
    JFrame frame = new JFrame("Random Number Guessing Game");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 200);
    frame.setLayout(new BorderLayout());

    JLabel label = new JLabel("Let's try to guess the number");
    frame.add(label, BorderLayout.NORTH);

    JTextField textField = new JTextField();
    textField.setPreferredSize(new Dimension(100, 30));
    JButton button = new JButton("Guess");
    JPanel panel = new JPanel();
    panel.add(textField);
    panel.add(button);
    frame.add(panel, BorderLayout.CENTER);

    JLabel resultLabel = new JLabel();
    frame.add(resultLabel, BorderLayout.SOUTH);

    button.addActionListener(new ActionListener() {
     
      public void actionPerformed(ActionEvent e) {
        int guess = Integer.parseInt(textField.getText());
        numberOfTries++;

        if (guess < Guess) {
          resultLabel.setText("Too low. Try again.");
        } else if (guess > Guess) {
          resultLabel.setText("Too high. Try again.");
        } else {
          resultLabel.setText("You got it! The number was " + Guess + ". It took you " + numberOfTries + " tries.");
          button.setEnabled(false);
        }
      }
    });

    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new RandomNumberGame();
  }
}