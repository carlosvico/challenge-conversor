package challenge_conversor;



import java.text.DecimalFormat;
import java.text.ParseException;

public class ValidaEformata {
    public static boolean validarNumero(String numero) {
        try {
            Double.parseDouble(numero.replace(",", "."));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String formatarNumero(double numero) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(numero);
    }

    public static double converterParaDouble(String numero) throws ParseException {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        decimalFormat.setParseBigDecimal(true);
        return decimalFormat.parse(numero).doubleValue();
    }
}
