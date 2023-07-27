package challenge_conversor;

import javax.swing.JOptionPane;

public class ConversorTemperatura {
    public static void executarConversao() {
        boolean continuar = true;

        while (continuar) {
            String[] opcoes = {
                "De Celsius para Fahrenheit",
                "De Fahrenheit para Celsius",
                "De Celsius para Kelvin",
                "De Kelvin para Celsius",
                "Voltar"
            };

            String opcaoSelecionada = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecione uma opção:",
                    "Conversor de Temperatura",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]);

            if (opcaoSelecionada != null) {
                switch (opcaoSelecionada) {
                    case "De Celsius para Fahrenheit":
                        converterCelsiusParaFahrenheit();
                        break;
                    case "De Fahrenheit para Celsius":
                        converterFahrenheitParaCelsius();
                        break;
                    case "De Celsius para Kelvin":
                        converterCelsiusParaKelvin();
                        break;
                    case "De Kelvin para Celsius":
                        converterKelvinParaCelsius();
                        break;
                    case "Voltar":
                        continuar = false;
                        break;
                }
            } else {
                continuar = false;
            }
        }
    }

    private static void converterCelsiusParaFahrenheit() {
        double celsius = obterTemperatura("Digite a temperatura em Celsius:");
        double fahrenheit = (celsius * 9 / 5) + 32;
        exibirResultado(celsius, "Celsius", fahrenheit, "Fahrenheit");
    }

    private static void converterFahrenheitParaCelsius() {
        double fahrenheit = obterTemperatura("Digite a temperatura em Fahrenheit:");
        double celsius = (fahrenheit - 32) * 5 / 9;
        exibirResultado(fahrenheit, "Fahrenheit", celsius, "Celsius");
    }

    private static void converterCelsiusParaKelvin() {
        double celsius = obterTemperatura("Digite a temperatura em Celsius:");
        double kelvin = celsius + 273.15;
        exibirResultado(celsius, "Celsius", kelvin, "Kelvin");
    }

    private static void converterKelvinParaCelsius() {
        double kelvin = obterTemperatura("Digite a temperatura em Kelvin:");
        double celsius = kelvin - 273.15;
        exibirResultado(kelvin, "Kelvin", celsius, "Celsius");
    }

    private static double obterTemperatura(String mensagem) {
        double temperatura;

        try {
            String temperaturaStr = JOptionPane.showInputDialog(mensagem);
            temperatura = Double.parseDouble(temperaturaStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Temperatura inválida! Digite um número válido.");
            temperatura = obterTemperatura(mensagem);
        }

        return temperatura;
    }

    private static void exibirResultado(double valorOrigem, String unidadeOrigem, double valorDestino, String unidadeDestino) {
        String resultadoFormatado = formatarValor(valorDestino);
        String mensagem = String.format("%s %s = %s %s", valorOrigem, unidadeOrigem, resultadoFormatado, unidadeDestino);
        JOptionPane.showMessageDialog(null, mensagem);
    }

    private static String formatarValor(double valor) {
        return String.format("%.2f", valor);
    }
}
