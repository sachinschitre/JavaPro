package src.main.java.demo;
public class AppUI {
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            javax.swing.JFrame frame = new javax.swing.JFrame("AppUI");
            frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            // Set a complex Look and Feel
            try {
                javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Create a JMenuBar with multiple menus and items
            javax.swing.JMenuBar menuBar = new javax.swing.JMenuBar();
            javax.swing.JMenu fileMenu = new javax.swing.JMenu("File");
            fileMenu.add(new javax.swing.JMenuItem("New"));
            fileMenu.add(new javax.swing.JMenuItem("Open"));
            fileMenu.add(new javax.swing.JMenuItem("Save"));
            fileMenu.addSeparator();
            fileMenu.add(new javax.swing.JMenuItem("Exit"));
            menuBar.add(fileMenu);

            javax.swing.JMenu editMenu = new javax.swing.JMenu("Edit");
            editMenu.add(new javax.swing.JMenuItem("Cut"));
            editMenu.add(new javax.swing.JMenuItem("Copy"));
            editMenu.add(new javax.swing.JMenuItem("Paste"));
            menuBar.add(editMenu);

            javax.swing.JMenu viewMenu = new javax.swing.JMenu("View");
            javax.swing.JMenu themeSubMenu = new javax.swing.JMenu("Theme");
            themeSubMenu.add(new javax.swing.JMenuItem("Light"));
            themeSubMenu.add(new javax.swing.JMenuItem("Dark"));
            viewMenu.add(themeSubMenu);
            menuBar.add(viewMenu);

            frame.setJMenuBar(menuBar);

            // Add a JToolBar with buttons and a combo box
            javax.swing.JToolBar toolBar = new javax.swing.JToolBar();
            toolBar.add(new javax.swing.JButton("New"));
            toolBar.add(new javax.swing.JButton("Open"));
            toolBar.add(new javax.swing.JButton("Save"));
            toolBar.addSeparator();
            toolBar.add(new javax.swing.JComboBox<>(new String[]{"Option 1", "Option 2", "Option 3"}));
            frame.add(toolBar, java.awt.BorderLayout.NORTH);

            // Add a JSplitPane with a JTree and a JTabbedPane
            javax.swing.JTree tree = new javax.swing.JTree();
            javax.swing.JScrollPane treeScroll = new javax.swing.JScrollPane(tree);

            javax.swing.JTabbedPane tabbedPane = new javax.swing.JTabbedPane();
            tabbedPane.addTab("Editor", new javax.swing.JTextArea());
            tabbedPane.addTab("Console", new javax.swing.JTextArea());
            tabbedPane.addTab("Properties", new javax.swing.JTable(
                new Object[][] {{"Name", "Value"}, {"Version", "1.0"}},
                new Object[] {"Property", "Value"}
            ));

            javax.swing.JSplitPane splitPane = new javax.swing.JSplitPane(
                javax.swing.JSplitPane.HORIZONTAL_SPLIT,
                treeScroll,
                tabbedPane
            );
            splitPane.setDividerLocation(120);

            // Add a status bar at the bottom
            javax.swing.JPanel statusBar = new javax.swing.JPanel(new java.awt.BorderLayout());
            javax.swing.JLabel statusLabel = new javax.swing.JLabel("Ready");
            javax.swing.JProgressBar progressBar = new javax.swing.JProgressBar();
            progressBar.setValue(50);
            statusBar.add(statusLabel, java.awt.BorderLayout.WEST);
            statusBar.add(progressBar, java.awt.BorderLayout.EAST);

            // Add a layered pane with a floating dialog
            javax.swing.JLayeredPane layeredPane = new javax.swing.JLayeredPane();
            layeredPane.setPreferredSize(new java.awt.Dimension(400, 300));
            javax.swing.JDialog floatingDialog = new javax.swing.JDialog(frame, "Floating", false);
            floatingDialog.setSize(120, 80);
            floatingDialog.setLocation(200, 100);
            floatingDialog.add(new javax.swing.JLabel("Floating Dialog"));
            layeredPane.add(floatingDialog.getContentPane(), javax.swing.JLayeredPane.POPUP_LAYER);

            // Add a glass pane with a custom painting
            frame.setGlassPane(new javax.swing.JPanel() {
                protected void paintComponent(java.awt.Graphics g) {
                    super.paintComponent(g);
                    g.setColor(new java.awt.Color(255, 0, 0, 64));
                    g.fillRect(50, 50, 100, 100);
                }
            });
            frame.getGlassPane().setVisible(true);

            // Replace panel's center with splitPane and add status bar to SOUTH
            // Create main panel with GridBagLayout
            javax.swing.JPanel panel = new javax.swing.JPanel(new java.awt.GridBagLayout());
            java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
            gbc.insets = new java.awt.Insets(5, 5, 5, 5);
            gbc.fill = java.awt.GridBagConstraints.BOTH;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;

            // Calculator Panel
            javax.swing.JPanel calcPanel = new javax.swing.JPanel(new java.awt.GridBagLayout());
            javax.swing.JTextField calcDisplay = new javax.swing.JTextField();
            calcDisplay.setEditable(false);
            gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 4;
            calcPanel.add(calcDisplay, gbc);
            gbc.gridwidth = 1;
            String[] calcBtns = {"7","8","9","/",
                                 "4","5","6","*",
                                 "1","2","3","-",
                                 "0",".","=","+"};
            int btnIdx = 0;
            for (int y = 1; y <= 4; y++) {
                for (int x = 0; x < 4; x++) {
                    javax.swing.JButton btn = new javax.swing.JButton(calcBtns[btnIdx++]);
                    gbc.gridx = x; gbc.gridy = y;
                    calcPanel.add(btn, gbc);
                }
            }
            calcPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Calculator"));

            // Chat Panel
            javax.swing.JPanel chatPanel = new javax.swing.JPanel(new java.awt.BorderLayout());
            javax.swing.JList<String> userList = new javax.swing.JList<>(new String[]{"Alice", "Bob", "Charlie"});
            userList.setBorder(javax.swing.BorderFactory.createTitledBorder("Users"));
            javax.swing.JTextArea chatArea = new javax.swing.JTextArea();
            chatArea.setEditable(false);
            javax.swing.JScrollPane chatScroll = new javax.swing.JScrollPane(chatArea);
            chatScroll.setBorder(javax.swing.BorderFactory.createTitledBorder("Chat"));
            javax.swing.JTextField chatInput = new javax.swing.JTextField();
            javax.swing.JButton sendBtn = new javax.swing.JButton("Send");
            javax.swing.JPanel chatInputPanel = new javax.swing.JPanel(new java.awt.BorderLayout());
            chatInputPanel.add(chatInput, java.awt.BorderLayout.CENTER);
            chatInputPanel.add(sendBtn, java.awt.BorderLayout.EAST);
            javax.swing.JSplitPane chatSplit = new javax.swing.JSplitPane(
                javax.swing.JSplitPane.HORIZONTAL_SPLIT,
                userList,
                chatScroll
            );
            chatSplit.setDividerLocation(80);
            chatPanel.add(chatSplit, java.awt.BorderLayout.CENTER);
            chatPanel.add(chatInputPanel, java.awt.BorderLayout.SOUTH);
            chatPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Chat Window"));

            // Movie Viewer Panel
            javax.swing.JPanel moviePanel = new javax.swing.JPanel(new java.awt.BorderLayout());
            javax.swing.JLabel movieLabel = new javax.swing.JLabel("Movie Viewer (Demo)", javax.swing.SwingConstants.CENTER);
            movieLabel.setFont(movieLabel.getFont().deriveFont(18f));
            javax.swing.JComboBox<String> movieList = new javax.swing.JComboBox<>(new String[]{"Movie 1", "Movie 2", "Movie 3"});
            javax.swing.JButton playBtn = new javax.swing.JButton("Play");
            javax.swing.JPanel movieControlPanel = new javax.swing.JPanel();
            movieControlPanel.add(movieList);
            movieControlPanel.add(playBtn);
            moviePanel.add(movieLabel, java.awt.BorderLayout.CENTER);
            moviePanel.add(movieControlPanel, java.awt.BorderLayout.SOUTH);
            moviePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Movie Viewer"));

            // Newsfeed Panel
            javax.swing.JPanel newsPanel = new javax.swing.JPanel(new java.awt.BorderLayout());
            javax.swing.DefaultListModel<String> newsModel = new javax.swing.DefaultListModel<>();
            newsModel.addElement("Breaking: Java 21 Released!");
            newsModel.addElement("UI Design Trends 2024");
            newsModel.addElement("AI Copilot Now Available");
            javax.swing.JList<String> newsList = new javax.swing.JList<>(newsModel);
            newsList.setBorder(javax.swing.BorderFactory.createTitledBorder("Newsfeed"));
            newsPanel.add(new javax.swing.JScrollPane(newsList), java.awt.BorderLayout.CENTER);
            newsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Newsfeed"));

            // Add panels to main panel using GridBagLayout
            gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.5; gbc.weighty = 0.5;
            panel.add(calcPanel, gbc);
            gbc.gridx = 1; gbc.gridy = 0;
            panel.add(chatPanel, gbc);
            gbc.gridx = 0; gbc.gridy = 1;
            panel.add(moviePanel, gbc);
            gbc.gridx = 1; gbc.gridy = 1;
            panel.add(newsPanel, gbc);

            // Add splitPane and statusBar to SOUTH
            gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2; gbc.weightx = 1.0; gbc.weighty = 0.3;
            panel.add(splitPane, gbc);
            gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; gbc.weighty = 0.1;
            panel.add(statusBar, gbc);
            javax.swing.JPanel panel1 = new javax.swing.JPanel();
            panel1.removeAll();
            panel1.setLayout(new java.awt.BorderLayout());
            panel1.add(splitPane, java.awt.BorderLayout.CENTER);
            panel1.add(statusBar, java.awt.BorderLayout.SOUTH);
            javax.swing.JTextArea textArea = new javax.swing.JTextArea();
            javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(textArea);

            javax.swing.JButton runButton = new javax.swing.JButton("Run");

                        javax.swing.JPanel panel2 = new javax.swing.JPanel();

            panel2.setLayout(new java.awt.BorderLayout());
            panel2.add(scrollPane, java.awt.BorderLayout.CENTER);
            panel2.add(runButton, java.awt.BorderLayout.SOUTH);

            frame.getContentPane().add(panel);
            frame.setVisible(true);
        });
    }
}
