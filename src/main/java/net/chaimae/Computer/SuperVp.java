package net.chaimae.Computer;

public class SuperVp implements Vga, Hdmi {

    @Override
    public void print(String message) {
        System.out.println("-----------SuperVP VGA-------------");
        System.out.println(message);
        System.out.println("-----------SuperVP VGA-------------");
    }

    @Override
    public void view(byte[] data) {
        System.out.println("-----------SuperVP HDMI-------------");
        System.out.println(new String(data));
        System.out.println("-----------SuperVP HDMI-------------");
    }
}