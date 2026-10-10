package net.chaimae.Computer;

public class SuperVp implements Vga,Hdmi{
    @Override
    public void print(String message) {
        String message =new String(data);
        System.out.println("-----------SuperVP Hdmi-------------");
        System.out.println(message);
        System.out.println("-----------SuperVP Hdmi-------------");
    }

    @Override
    public void print(String message) {
        System.out.println("-----------SuperVp Vga-------------");
        System.out.println( message);
        System.out.println("-----------SuperVP VGA-------------");
    }
}
