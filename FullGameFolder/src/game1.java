import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class game1 extends JFrame {
    private Timer forStage;
    private boolean isFunctionRunning = false;
    private int index = 0;  // Переменная для отслеживания текущей позиции в тексте
    private JButton fight;
    private JButton act;
    private JButton items;
    private JButton spare;
    private JLabel Text;
    private JLabel YourHpLabel;
    private JLabel EnemyHpLabel;
    private JLabel spareValueLabel;
    private JPanel main;
    private int EnemyHp = 20;
    private int YourHp = 20;
    private int spareValue = 0;
    private int stage = 1;

    private player player;
    private ImageIcon playerIcon;
    private bullets1 bullets1;
    private ImageIcon bulletIcon;
    //private JPanel playerLabel;

    private JButton noodles;
    private int ifNoodles = 1;
    private JButton borsh;
    private int ifBorsh = 1;
    private JButton juice;
    private int ifJuice = 1;
    private JButton carrots;
    private int ifCarrots = 1;
    private ArrayList<bullets1> bullets;
    public game1() {
        super("Program");

        JLayeredPane layeredPane = new JLayeredPane();


        Text = new JLabel("");
        YourHpLabel = new JLabel("Your HP: " + YourHp);
        EnemyHpLabel = new JLabel("Hp of an enemy: " + EnemyHp);
        spareValueLabel = new JLabel("Spare value: " + spareValue);
        fight = new JButton("Fight");
        act = new JButton("Act");
        items = new JButton("Items");
        spare = new JButton("Spare");

        noodles = new JButton("Noodles");
        borsh = new JButton("Borsh");
        juice = new JButton("Juice");
        carrots = new JButton("Carrots");

        noodles.setVisible(false);
        borsh.setVisible(false);
        juice.setVisible(false);
        carrots.setVisible(false);

        fight.setPreferredSize(new Dimension(150, 100));
        act.setPreferredSize(new Dimension(150, 100));
        items.setPreferredSize(new Dimension(150, 100));
        spare.setPreferredSize(new Dimension(150, 100));

        main = new JPanel(new BorderLayout());

        JPanel labels = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 10));
        JPanel textBox = new JPanel(new FlowLayout(FlowLayout.CENTER));

        labels.add(YourHpLabel);
        labels.add(EnemyHpLabel);
        labels.add(Text);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 10));
        JPanel food = new JPanel(new FlowLayout(FlowLayout.LEFT, 40, 10));

        textBox.add(Text);
        buttons.add(fight);
        buttons.add(act);
        buttons.add(items);
        buttons.add(spare);

        food.add(noodles);
        food.add(borsh);
        food.add(juice);
        food.add(carrots);

        main.add(labels, BorderLayout.NORTH);
        main.add(buttons, BorderLayout.SOUTH);
        main.add(textBox, BorderLayout.WEST);
        main.add(food, BorderLayout.EAST);

        Font largerFont = new Font(YourHpLabel.getFont().getName(), Font.PLAIN, 24);
        YourHpLabel.setFont(largerFont);
        EnemyHpLabel.setFont(largerFont);
        Text.setFont(largerFont);
        fight.setFont(largerFont);
        act.setFont(largerFont);
        items.setFont(largerFont);
        spare.setFont(largerFont);
        playerIcon = new ImageIcon("player.png");
        bulletIcon = new ImageIcon("bullet1.png");
        bullets = new ArrayList<>();
        player = new player(playerIcon, 300, 300);
        bullets1 = new bullets1(bulletIcon, 200, 200);

        //JPanel vmeste = new JPanel();
        //vmeste.add(player);
        //vmeste.add(bullets1);
        //main.add(bullets1);
        //JPanel main1 = new JPanel(new BorderLayout());
        //main1.add(player, BorderLayout.CENTER);
        //main1.add(bullets1, BorderLayout.NORTH);
        main.add(player, BorderLayout.CENTER);
        add(main);
        player.requestFocus();

        setBounds(400, 100, 800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setStage1();
        for (bullets1 bullet : bullets) {
            //main.add(bullet);
        }
        initListeners();

        player.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Не используется в данном контексте
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("a");
                player.updateKeyState(e.getKeyCode(), true);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.updateKeyState(e.getKeyCode(), false);
            }
        });


    }

    private void initListeners() {
        fight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //turningOffButtons(8000);
                EnemyHp = (int) (EnemyHp - Math.random() * 3);
                updateHp();
                turningOff();
                showText("You hit the person. Feeling great?", 30, 2000, true, new AnimationCompleteListener() {

                    @Override
                    public void onAnimationComplete() {

                        System.out.println("wada");
                        setStage2(8000);
                        updateHp();
                    }
                });
            }
        });
        spare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spareValue = spareValue + 5;
                if (spareValue >= 20) {
                    //END THE GAME
                }
                setStage2(8000);
                //set stage 2
                updateHp();
            }
        });

        items.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (noodles.isVisible() || borsh.isVisible() || juice.isVisible() || carrots.isVisible()) {
                    itemsOff();
                    clearText();
                }
                else {
                    showText("Choose what to eat: ", 30, 0, false, new AnimationCompleteListener() {
                        @Override
                        public void onAnimationComplete() {
                            itemsOn();
                            System.out.println("wada");
                            updateHp();
                        }
                    });

                }
                //draw a box where you choose what to eat and restore hp set stage 2
            }
        });

        noodles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ifNoodles = 0;
                itemsOff();
                turningOff();
                if (YourHp + 5 <= 30) {
                    YourHp += 5;
                }
                else {
                    YourHp = 30;
                }
                updateHp();
                showText("You have just eaten noodles yummy", 30, 1000, true, new AnimationCompleteListener() {
                    @Override
                    public void onAnimationComplete() {
                        itemsOff();
                        setStage2(8000);
                        updateHp();
                    }
                });
            }
        });
        borsh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ifBorsh = 0;
                itemsOff();
                turningOff();
                if (YourHp + 6 <= 30) {
                    YourHp += 6;
                }
                else {
                    YourHp = 30;
                }
                updateHp();
                showText("You have just eaten Borsh. Beetroot.", 30, 1000, true, new AnimationCompleteListener() {
                    @Override
                    public void onAnimationComplete() {
                        itemsOff();
                        setStage2(8000);
                        updateHp();
                    }
                });
            }
        });
        juice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ifJuice = 0;
                itemsOff();
                turningOff();
                if (YourHp + 1 <= 30) {
                    YourHp += 1;
                }
                else {
                    YourHp = 30;
                }
                updateHp();
                showText("You drank juice. Was not tasty", 30, 1000, true, new AnimationCompleteListener() {
                    @Override
                    public void onAnimationComplete() {
                        itemsOff();
                        setStage2(8000);
                        updateHp();
                    }
                });
            }
        });
        carrots.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemsOff();
                turningOff();
                if (YourHp + 3 <= 30) {
                    YourHp += 3;
                }
                else {
                    YourHp = 30;
                }
                updateHp();
                showText("A u a rabbit?", 30, 1000, true, new AnimationCompleteListener() {
                    @Override
                    public void onAnimationComplete() {
                        itemsOff();
                        setStage2(8000);
                        updateHp();
                    }
                });
            }
        });
    }


    private void updateHp() { //updating values
        EnemyHpLabel.setText("Enemy's HP:" + EnemyHp);
        YourHpLabel.setText("Your HP: " + YourHp);
        spareValueLabel.setText("Spare value:" + spareValue);

    }

    private interface AnimationCompleteListener {
        void onAnimationComplete();
    }

    private void showText(String text, int delay, int duration, boolean dissapear, AnimationCompleteListener listener) {
        player.setVisible(false);
        if (isFunctionRunning) {
            return;  // Если функция уже выполняется, просто выходим
        }
        isFunctionRunning = true;  // Устанавливаем флаг, что функция выполняется
        Timer timer = null;
        Timer clearTimer = null;
        if (timer != null && timer.isRunning()) {
            timer.stop();   // Остановить предыдущий таймер, если он существует и запущен
            clearTimer.stop();
        }

        index = 0;
        Text.setText("");
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (index < text.length()) {
                    Text.setText(Text.getText() + text.charAt(index));
                    index++;
                } else {
                    ((Timer) e.getSource()).stop();

                        Timer clearTimer = new Timer(duration, new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                if (dissapear == true) {
                                    Text.setText("");
                                }
                                isFunctionRunning = false;
                                if (listener != null) {
                                    listener.onAnimationComplete();
                                }
                            }
                        });
                        if (clearTimer != null && clearTimer.isRunning()) {
                            clearTimer.stop();
                        }
                        clearTimer.setRepeats(false);
                        clearTimer.start();

                }
            }
        });
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        timer.start();
    }

    private void turningOn() {
        fight.setEnabled(true);
        act.setEnabled(true);
        items.setEnabled(true);
        spare.setEnabled(true);
    }

    private void turningOff() {
        fight.setEnabled(false);
        act.setEnabled(false);
        items.setEnabled(false);
        spare.setEnabled(false);
    }

    private void turningOffButtons(int seconds) {
        fight.setEnabled(false);
        act.setEnabled(false);
        items.setEnabled(false);
        spare.setEnabled(false);
        Timer turningOff = new Timer(seconds, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fight.setEnabled(true);
                act.setEnabled(true);
                items.setEnabled(true);
                spare.setEnabled(true);
            }
        });
        if (turningOff != null && turningOff.isRunning()) {
            turningOff.stop();
        }
        //turningOff.setRepeats(false);
        turningOff.start();
    }

    private void setStage1() {
        turningOn();
        player.setVisible(false);
        bullets = new ArrayList<>(); // Создаем новый список пуль
        bullets.add(new bullets1(bulletIcon, 0, 100));
        for (bullets1 bullet : bullets) {
            //main.add(bullet); // Добавляем пули в панель последнее изменение
        }
    }
    private void itemsOn() {
        if (ifNoodles == 1) {
            noodles.setVisible(true);
        }
        if (ifCarrots == 1) {
            carrots.setVisible(true);
        }
        if (ifBorsh == 1) {
            borsh.setVisible(true);
        }
        if (ifJuice == 1) {
            juice.setVisible(true);
        }

    }
    private void itemsOff() {
        noodles.setVisible(false);
        borsh.setVisible(false);
        juice.setVisible(false);
        carrots.setVisible(false);
    }
    private void setStage2(int delay) {
        player.setDirection0();
        turningOff();
        player.setCenter();
        player.setVisible(true);
        player.requestFocusInWindow();
        moveBullets();
        if (forStage != null && forStage.isRunning()) {
            forStage.stop();
        }


        Timer forStage = new Timer(10, new ActionListener() {
            int elapsedTime = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                player.movePlayer();
                moveBullets();
                //checkCollisions();
                elapsedTime += 10;

                for (bullets1 bullet : bullets) {


                }


                if (elapsedTime >= 8000) {
                    ((Timer) e.getSource()).stop();
                    setStage1();
                }
            }
        });
        forStage.start();

    }
    private void moveBullets() {
        for (bullets1 bullet : bullets) {
            bullet.moveBullets();

        }
    }
//    private void checkCollisions() {
//        Rectangle playerBounds = player.getBounds();
//        for (bullets1 bullet : bullets) {
//            if (playerBounds.intersects(bullet.getBounds())) {
//                YourHp -=5;
//                updateHp();
//                bullet.setLocation(-100, -100);
//            }
//
//        }
//    }
    private void clearText() {
        Text.setText("");
    }
}
