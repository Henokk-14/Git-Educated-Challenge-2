package src;
/*
 * Title: Git-Educated-Challenge-2
 * GUI made by: Andrew Matos & Jack Handy
 * Backend Programming by:
 * Date: 4/11/21
 */

import git.tools.client.GitSubprocessClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JPanel {
    private String repoPath = "";
    private GitSubprocessClient Client;
    private GitHubCommands command;

	Color lightMode = Color.white;
	Color darkMode = Color.getHSBColor(convertRGBtoHSV(25,25,25)[0],convertRGBtoHSV(25,25,25)[1],convertRGBtoHSV(25,25,25)[2]);
	Color greyMode = Color.getHSBColor(convertRGBtoHSV(40,40,40)[0],convertRGBtoHSV(40,40,40)[1],convertRGBtoHSV(40,40,40)[2]);
	Color lightgreyMode = Color.getHSBColor(convertRGBtoHSV(180,180,180)[0],convertRGBtoHSV(180,180,180)[1],convertRGBtoHSV(180,180,180)[2]);
	Color buttonColor = Color.getHSBColor(convertRGBtoHSV(60,60,60)[0],convertRGBtoHSV(60,60,60)[1],convertRGBtoHSV(60,60,60)[2]);



	public float[] convertRGBtoHSV(int R, int B, int G) {
		float[] hsb = Color.RGBtoHSB(R,G,B,null);
        float hue = hsb[0];
        float saturation = hsb[1];
        float brightness = hsb[2];
        return hsb;
	}

	public App() {
        super(new BorderLayout());

      //  Client = new GitSubprocessClient(repoPath);
        command = new GitHubCommands();

        // CREATING JFRAME
        JPanel DrawingPanel = new JPanel();
        BorderLayout layout = new BorderLayout();
        DrawingPanel.setLayout(layout);

        // CREATING TEXT LABEL
        JLabel TitleText = new JLabel("Git Educated Challenge 2");

        // CREATING BUTTONS
        JRadioButton darkModeButton = new JRadioButton("Dark Mode");
        JButton statusButton = new JButton("Status");
        JButton addButton = new JButton("Add");
        JButton commitButton = new JButton("Commit");
        JButton pushButton = new JButton("Push");
        JButton clButton = new JButton("Clear Input");

        // SETTING BUTTONS
        statusButton.setBackground(buttonColor);
        statusButton.setForeground(Color.CYAN);
        addButton.setBackground(buttonColor);
        addButton.setForeground(Color.CYAN);
        commitButton.setBackground(buttonColor);
        commitButton.setForeground(Color.CYAN);
        pushButton.setBackground(buttonColor);
        pushButton.setForeground(Color.CYAN);
        clButton.setBackground(buttonColor);
        clButton.setForeground(Color.CYAN);

        // CREATING TITLE TEXT
        JPanel titlePanel = new JPanel(new FlowLayout());
        titlePanel.setBackground(darkMode);
        titlePanel.add(TitleText);
        TitleText.setForeground(Color.white);

        // DARK MODE BUTTON
        JPanel northPanel = new JPanel(new GridLayout());
        northPanel.setBackground(darkMode);
        northPanel.add(darkModeButton);
        darkModeButton.setBackground(darkMode);
        darkModeButton.setForeground(Color.WHITE);
        darkModeButton.setSelected(true);


        // RADIO BUTTONS
        JPanel southPanel = new JPanel(new FlowLayout());
        southPanel.setBackground(darkMode);
        southPanel.add(statusButton);
        southPanel.add(addButton);
        southPanel.add(commitButton);
        southPanel.add(pushButton);
        southPanel.add(clButton);

        // TEXT BOXES AND OUTPUT
        JPanel centerPanel = new JPanel(new GridLayout());
        JPanel eastPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel leftSide = new JPanel(new GridLayout());
        JPanel rightSide = new JPanel(new GridLayout());

        // CREATING JTEXTAREAS
        JTextArea inputFrame = new JTextArea("");
        inputFrame.setEditable(true);
        inputFrame.setLineWrap(true);
        inputFrame.setWrapStyleWord(true);
        inputFrame.setForeground(Color.white);
        inputFrame.setBackground(greyMode);

        JTextArea outputFrame = new JTextArea("Please enter the full repo directory on the left text box before checking status.");
        outputFrame.setEditable(false);
        outputFrame.setLineWrap(true);
        outputFrame.setWrapStyleWord(true);
        outputFrame.setForeground(Color.white);
        outputFrame.setBackground(greyMode);

        // CREATING JSPLITPANE
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftSide, rightSide);
        splitPane.setResizeWeight(0.52);
        leftSide.add(inputFrame);
        rightSide.add(outputFrame);
        centerPanel.add(splitPane);

        centerPanel.setBackground(greyMode);
        eastPanel.setBackground(darkMode);
        westPanel.setBackground(darkMode);
        DrawingPanel.setBackground(darkMode);

        // ADDING ACTION EVENT LISTENERS
        darkModeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO DO STATUS CODE HERE
                if (darkModeButton.isSelected() == true) {
                	// dark mode enabled
                	statusButton.setBackground(buttonColor);
                    statusButton.setForeground(Color.CYAN);
                    addButton.setBackground(buttonColor);
                    addButton.setForeground(Color.CYAN);
                    commitButton.setBackground(buttonColor);
                    commitButton.setForeground(Color.CYAN);
                    pushButton.setBackground(buttonColor);
                    pushButton.setForeground(Color.CYAN);
                    clButton.setBackground(buttonColor);
                    clButton.setForeground(Color.CYAN);

                	titlePanel.setBackground(darkMode);
                    TitleText.setForeground(Color.white);

                	northPanel.setBackground(darkMode);
                	darkModeButton.setBackground(darkMode);
                    darkModeButton.setForeground(Color.white);

                	southPanel.setBackground(darkMode);

                	inputFrame.setForeground(Color.white);
                    inputFrame.setBackground(greyMode);
                	outputFrame.setForeground(Color.white);
                    outputFrame.setBackground(greyMode);

                	centerPanel.setBackground(greyMode);
                    eastPanel.setBackground(darkMode);
                    westPanel.setBackground(darkMode);
                    DrawingPanel.setBackground(darkMode);
                } else {
                	// dark mode disabled
                	statusButton.setBackground(lightgreyMode);
                    statusButton.setForeground(Color.black);
                    addButton.setBackground(lightgreyMode);
                    addButton.setForeground(Color.black);
                    commitButton.setBackground(lightgreyMode);
                    commitButton.setForeground(Color.black);
                    pushButton.setBackground(lightgreyMode);
                    pushButton.setForeground(Color.black);
                    clButton.setBackground(lightgreyMode);
                    clButton.setForeground(Color.black);

                	titlePanel.setBackground(Color.white);
                    TitleText.setForeground(Color.black);

                	northPanel.setBackground(Color.white);
                	darkModeButton.setBackground(Color.white);
                    darkModeButton.setForeground(Color.black);

                	southPanel.setBackground(Color.white);

                	inputFrame.setForeground(Color.black);
                    inputFrame.setBackground(lightgreyMode);
                	outputFrame.setForeground(Color.black);
                    outputFrame.setBackground(lightgreyMode);

                	centerPanel.setBackground(greyMode);
                    eastPanel.setBackground(Color.white);
                    westPanel.setBackground(Color.white);
                    DrawingPanel.setBackground(darkMode);
                }
            }
        });

        statusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (repoPath == "") {
                    if(inputFrame.getText().length() > 2) {
                        repoPath = inputFrame.getText();
                    }
                    Client = new GitSubprocessClient(repoPath);
                } else {
                    Client = new GitSubprocessClient(repoPath);
                }
                String outputTxt = command.GitStatus(Client, repoPath);
                if(outputTxt == "You have entered the wrong repo please try again:)"){
                    repoPath = "";
                }
                outputFrame.setText(outputTxt);

                
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = inputFrame.getText();
                outputFrame.setText(command.GitAdd(Client, fileName));
            }
        });

        commitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String commitMsg = inputFrame.getText();
                outputFrame.setText(command.Commit(Client, commitMsg));
            }
        });

        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String branchName = inputFrame.getText();
                outputFrame.setText(command.Push(Client, branchName));
            }
        });

        clButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputFrame.setText("");
            }
        });

        // ADDING PANEL TO JFRAME

        add(titlePanel,BorderLayout.NORTH);
        DrawingPanel.add(northPanel,BorderLayout.NORTH);
        DrawingPanel.add(southPanel,BorderLayout.SOUTH);
        DrawingPanel.add(centerPanel,BorderLayout.CENTER);
        DrawingPanel.add(eastPanel,BorderLayout.EAST);
        DrawingPanel.add(westPanel,BorderLayout.WEST);

        add(DrawingPanel);

    }

	private static void createAndShowGUI(Runnable t) {
        //Create and set up the window.
        JFrame frame = new JFrame("Working Together Pt.3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent newContentPane = new App();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);



        frame.getContentPane().setBackground(Color.BLACK);
        frame.setResizable(false);
        frame.pack();

        frame.setVisible(true);
    }


	@Override
    public Dimension getPreferredSize() {
        return new Dimension(800,500);  // CHANGES JFRAME DIMENSIONS
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               createAndShowGUI(this);
            }
        });
    }

}



