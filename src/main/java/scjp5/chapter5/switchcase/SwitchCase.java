package java.scjp5.chapter5.switchcase;

public class SwitchCase {

    public static void main(String[] args) {
        byte b = 3;
        int i = 2;

        switch (b) {
            case 1:
                System.out.println("byte 1 case");
                break;

//		case 128:
//			System.out.println("byte 2 case");
//			break;
            default:
                break;

            case 2:
                System.out.println("byte 2 case");
                break;
        }
    }

}
