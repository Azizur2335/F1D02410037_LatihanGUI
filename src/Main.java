import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Main extends JFrame {
    private CardLayout cardLayout;
    private JPanel panelUtama;
    private HalamanDetail halamanDetail;

    public static final String[] JUDUL = {
        "The Genius Knight Of A Fallen Race", "Invincible Mumu", "The Perfect Senior's Secret!",
        "Kagurabachi"
    };
    public static final String[] GAMBAR = {
        "tgkfr.jpg", "mumu.jpg", "perfectsenior.jpg", "kagurabachi.jpg"
    };
    public static final String[] GENRE = {
        "Manhwa · Ongoing", "Manhwa · Ongoing", "Manhwa · Ongoing",
        "Manga · Ongoing"
    };
    public static final String[] RATING = {"8.5", "8.5", "7.0", "8.0"};
    public static final String[] CHAPTER = {
        "Chapter 10", "Chapter 7", "Chapter 37", "Chapter 140"
    };
    public static final String[] SINOPSIS = {
        "Seorang ksatria berbakat dari ras yang dicap sebagai musuh berusaha membuktikan dirinya di dunia yang menolaknya.",
        "Mumu, seorang pemuda yang tak terkalahkan, menjalani petualangan penuh pertarungan.",
        "Seorang mahasiswa ambisius selalu berusaha melampaui rivalnya, sampai rahasia sang senior mulai terungkap.",
        "Mantan murid penempa pedang menempuh jalan balas dendam melawan para gangster."
    };

    public Main() {
        super("Shinigami");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 680);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(buatNavbar(), BorderLayout.NORTH);

        cardLayout = new CardLayout();
        panelUtama = new JPanel(cardLayout);

        halamanDetail = new HalamanDetail(this);

        panelUtama.add(new HalamanBeranda(this), "Beranda");
        panelUtama.add(new HalamanKomik(this), "Komik");
        panelUtama.add(halamanDetail, "Detail");
        add(panelUtama, BorderLayout.CENTER);

        bukaHalaman("Beranda");
    }

    public void bukaHalaman(String nama) {
        cardLayout.show(panelUtama, nama);
    }

    public void bukaDetail(int index) {
        halamanDetail.setKomik(index);
        cardLayout.show(panelUtama, "Detail");
    }

    public static ImageIcon ambilGambar(String namaFile, int lebar, int tinggi) {
        File file = new File("../assets/" + namaFile);
        Image img = new ImageIcon(file.getPath()).getImage();
        return new ImageIcon(img.getScaledInstance(lebar, tinggi, Image.SCALE_SMOOTH));
    }

    private JPanel buatNavbar() {
        JPanel navbar = new JPanel(new BorderLayout());
        navbar.setBackground(Theme.BG);
        navbar.setBorder(new EmptyBorder(8, 20, 8, 20));

        navbar.add(new JLabel(ambilGambar("logo.png", 140, 40)), BorderLayout.WEST);

        JPanel menu = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 8));
        menu.setOpaque(false);
        String[] daftarMenu = {"Beranda", "Komik"};
        for (String nama : daftarMenu) {
            JButton btn = new JButton(nama);
            btn.setFont(Theme.MENU);
            btn.setForeground(Theme.PUTIH);
            btn.setContentAreaFilled(false);
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bukaHalaman(e.getActionCommand());
                }
            });
            menu.add(btn);
        }
        navbar.add(menu, BorderLayout.CENTER);

        navbar.add(new JLabel(ambilGambar("avatar.png", 40, 40)), BorderLayout.EAST);
        return navbar;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}