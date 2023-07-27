package challenge_conversor;
//
//import javax.swing.JOptionPane;
//import challenge_conversor.ConversorTemperatura;
//
//
//public class ConversorRun {
//    public static void main(String[] args) {
//        boolean continuar = true;
//
//        while (continuar) {
//            String[] opcoes = {
//                "Converter de Reais a Dólar",
//                "Converter de Reais a Euro",
//                "Converter de Reais a Libras Esterlinas",
//                "Converter de Reais a Peso argentino",
//                "Converter de Reais a Peso Chileno",
//                "Converter de Dólar a Reais",
//                "Converter de Euro a Reais",
//                "Converter de Libras Esterlinas a Reais",
//                "Converter de Peso argentino a Reais",
//                "Converter de Peso Chileno a Reais",
//                "Conversão de Temperatura", // Nova opção de conversão
//                "Sair"
//            };
//
//            String opcaoSelecionada = (String) JOptionPane.showInputDialog(
//                    null,
//                    "Selecione uma opção:",
//                    "Conversor de Moedas",
//                    JOptionPane.PLAIN_MESSAGE,
//                    null,
//                    opcoes,
//                    opcoes[0]);
//
//            if (opcaoSelecionada != null) {
//                if (opcaoSelecionada.equals("Sair")) {
//                    continuar = false;
//                } else {
//                    double valor = obterValor();
//
//                    double resultado = 0.0;
//                    String moedaOrigem = "";
//                    String moedaDestino = "";
//
//                    switch (opcaoSelecionada) {
//                        case "Converter de Reais a Dólar":
//                            moedaOrigem = "Reais";
//                            moedaDestino = "Dólar";
//                            resultado = ConversorMoedas.converterMoeda(moedaOrigem, moedaDestino, valor);
//                            break;
//                        case "Converter de Reais a Euro":
//                            moedaOrigem = "Reais";
//                            moedaDestino = "Euro";
//                            resultado = ConversorMoedas.converterMoeda(moedaOrigem, moedaDestino, valor);
//                            break;
//                        case "Converter de Reais a Libras Esterlinas":
//                            moedaOrigem = "Reais";
//                            moedaDestino = "Libras Esterlinas";
//                            resultado = ConversorMoedas.converterMoeda(moedaOrigem, moedaDestino, valor);
//                            break;
//                        case "Converter de Reais a Peso argentino":
//                            moedaOrigem = "Reais";
//                            moedaDestino = "Peso argentino";
//                            resultado = ConversorMoedas.converterMoeda(moedaOrigem, moedaDestino, valor);
//                            break;
//                        case "Converter de Reais a Peso Chileno":
//                            moedaOrigem = "Reais";
//                            moedaDestino = "Peso Chileno";
//                            resultado = ConversorMoedas.converterMoeda(moedaOrigem, moedaDestino, valor);
//                            break;
//                        case "Converter de Dólar a Reais":
//                            moedaOrigem = "Dólar";
//                            moedaDestino = "Reais";
//                            resultado = ConversorMoedas.converterMoeda(moedaOrigem, moedaDestino, valor);
//                            break;
//                        case "Converter de Euro a Reais":
//                            moedaOrigem = "Euro";
//                            moedaDestino = "Reais";
//                            resultado = ConversorMoedas.converterMoeda(moedaOrigem, moedaDestino, valor);
//                            break;
//                        case "Converter de Libras Esterlinas a Reais":
//                            moedaOrigem = "Libras Esterlinas";
//                            moedaDestino = "Reais";
//                            resultado = ConversorMoedas.converterMoeda(moedaOrigem, moedaDestino, valor);
//                            break;
//                        case "Converter de Peso argentino a Reais":
//                            moedaOrigem = "Peso argentino";
//                            moedaDestino = "Reais";
//                            resultado = ConversorMoedas.converterMoeda(moedaOrigem, moedaDestino, valor);
//                            break;
//                        case "Converter de Peso Chileno a Reais":
//                            moedaOrigem = "Peso Chileno";
//                            moedaDestino = "Reais";
//                            resultado = ConversorMoedas.converterMoeda(moedaOrigem, moedaDestino, valor);
//                            break;
//                        case "Conversão de Temperatura":
//                            ConversorTemperatura.executarConversao();
//                            break;
//                    }
//
//                    String resultadoFormatado = ConversorMoedas.formatarValor(resultado, moedaDestino);
//                    String mensagem = "Resultado da conversão: " + resultadoFormatado;
//                    JOptionPane.showMessageDialog(null, mensagem);
//                }
//            } else {
//                continuar = false;
//            }
//        }
//    }
//
//    private static double obterValor() {
//        double valor;
//
//        try {
//            String valorStr = JOptionPane.showInputDialog("Digite o valor a ser convertido:");
//            valor = Double.parseDouble(valorStr);
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(null, "Valor inválido! Digite um número válido.");
//            valor = obterValor();
//        }
//
//        return valor;
//    }
//}


import javax.swing.JOptionPane;

public class ConversorRun {
    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            String[] opcoes = {
                "Converter Moeda",
                "Converter Temperatura",
                "Sair"
            };

            String opcaoSelecionada = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecione uma opção:",
                    "Conversor",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]);

            if (opcaoSelecionada != null) {
                if (opcaoSelecionada.equals("Sair")) {
                    continuar = false;
                } else if (opcaoSelecionada.equals("Converter Moeda")) {
                    executarConversaoMoeda();
                } else if (opcaoSelecionada.equals("Converter Temperatura")) {
                    ConversorTemperatura.executarConversao();
                }
            } else {
                continuar = false;
            }
        }

        JOptionPane.showMessageDialog(null, "Obrigado por usar o Conversor! Volte sempre!");
    }

    private static void executarConversaoMoeda() {
        boolean continuar = true;

        while (continuar) {
            String[] opcoes = {
                "De Reais a Dólar",
                "De Reais a Euro",
                "De Reais a Libras Esterlinas",
                "De Reais a Peso argentino",
                "De Reais a Peso Chileno",
                "De Dólar a Reais",
                "De Euro a Reais",
                "De Libras Esterlinas a Reais",
                "De Peso argentino a Reais",
                "De Peso Chileno a Reais",
                "Voltar"
            };

            String opcaoSelecionada = (String) JOptionPane.showInputDialog(
                    null,
                    "Selecione uma opção:",
                    "Conversor de Moedas",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]);

            if (opcaoSelecionada != null) {
                if (opcaoSelecionada.equals("Voltar")) {
                    continuar = false;
                } else {
                    double valor = obterValor();

                    double resultado = 0.0;
                    String moedaOrigem = "";
                    String moedaDestino = "";

                    switch (opcaoSelecionada) {
                        case "De Reais a Dólar":
                            moedaOrigem = "Reais";
                            moedaDestino = "Dólar";
                            resultado = ConversorMoedas.converterMoeda(moedaOrigem, moedaDestino, valor);
                            break;
                        case "De Reais a Euro":
                            moedaOrigem = "Reais";
                            moedaDestino = "Euro";
                            resultado = ConversorMoedas.converterMoeda(moedaOrigem, moedaDestino, valor);
                            break;
                        case "De Reais a Libras Esterlinas":
                            moedaOrigem = "Reais";
                            moedaDestino = "Libras Esterlinas";
                            resultado = ConversorMoedas.converterMoeda(moedaOrigem, moedaDestino, valor);
                            break;
                        case "De Reais a Peso argentino":
                            moedaOrigem = "Reais";
                            moedaDestino = "Peso argentino";
                            resultado = ConversorMoedas.converterMoeda(moedaOrigem, moedaDestino, valor);
                            break;
                        case "De Reais a Peso Chileno":
                            moedaOrigem = "Reais";
                            moedaDestino = "Peso Chileno";
                            resultado = ConversorMoedas.converterMoeda(moedaOrigem, moedaDestino, valor);
                            break;
                        case "De Dólar a Reais":
                            moedaOrigem = "Dólar";
                            moedaDestino = "Reais";
                            resultado = ConversorMoedas.converterMoeda(moedaOrigem, moedaDestino, valor);
                            break;
                        case "De Euro a Reais":
                            moedaOrigem = "Euro";
                            moedaDestino = "Reais";
                            resultado = ConversorMoedas.converterMoeda(moedaOrigem, moedaDestino, valor);
                            break;
                        case "De Libras Esterlinas a Reais":
                            moedaOrigem = "Libras Esterlinas";
                            moedaDestino = "Reais";
                            resultado = ConversorMoedas.converterMoeda(moedaOrigem, moedaDestino, valor);
                            break;
                        case "De Peso argentino a Reais":
                            moedaOrigem = "Peso argentino";
                            moedaDestino = "Reais";
                            resultado = ConversorMoedas.converterMoeda(moedaOrigem, moedaDestino, valor);
                            break;
                        case "De Peso Chileno a Reais":
                            moedaOrigem = "Peso Chileno";
                            moedaDestino = "Reais";
                            resultado = ConversorMoedas.converterMoeda(moedaOrigem, moedaDestino, valor);
                            break;
                    }

                    String resultadoFormatado = ConversorMoedas.formatarValor(resultado, moedaDestino);
                    String mensagem = "O valor da conversão é de " + resultadoFormatado;
                    JOptionPane.showMessageDialog(null, mensagem);
                }
            } else {
                continuar = false;
            }
        }
    }

    private static double obterValor() {
        double valor;

        try {
            String valorStr = JOptionPane.showInputDialog("Digite o valor a ser convertido:");
            valor = Double.parseDouble(valorStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Valor inválido! Digite um número válido.");
            valor = obterValor();
        }

        return valor;
    }
}

