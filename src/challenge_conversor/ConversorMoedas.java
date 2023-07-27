package challenge_conversor;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class ConversorMoedas {
    private static Map<String, Double> cotacoes = new HashMap<>();

    static {
        atualizarCotacoes();
    }

    private static void atualizarCotacoes() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://economia.awesomeapi.com.br/json/last/USD-BRL,EUR-BRL,GBP-BRL,ARS-BRL,CLP-BRL"))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject json = new JSONObject(response.body());

            double cotacaoDolar = json.getJSONObject("USDBRL").getDouble("bid");
            double cotacaoEuro = json.getJSONObject("EURBRL").getDouble("bid");
            double cotacaoLibra = json.getJSONObject("GBPBRL").getDouble("bid");
            double cotacaoPesoArgentino = json.getJSONObject("ARSBRL").getDouble("bid");
            double cotacaoPesoChileno = json.getJSONObject("CLPBRL").getDouble("bid");

            cotacoes.put("Dólar", cotacaoDolar);
            cotacoes.put("Euro", cotacaoEuro);
            cotacoes.put("Libras Esterlinas", cotacaoLibra);
            cotacoes.put("Peso argentino", cotacaoPesoArgentino);
            cotacoes.put("Peso Chileno", cotacaoPesoChileno);
        } catch (URISyntaxException | IOException | InterruptedException | JSONException e) {
            System.out.println("Ocorreu um erro ao atualizar as cotações. As cotações anteriores serão utilizadas.");
        }
    }

    public static double converterMoeda(String moedaOrigem, String moedaDestino, double valor) {
        double resultado = 0.0;

        if (moedaOrigem.equals("Reais")) {
            resultado = converterRealParaMoeda(moedaDestino, valor);
        } else if (moedaDestino.equals("Reais")) {
            resultado = converterMoedaParaReal(moedaOrigem, valor);
        } else {
            double taxaOrigem = obterTaxaConversao(moedaOrigem);
            double taxaDestino = obterTaxaConversao(moedaDestino);

            resultado = valor * taxaDestino / taxaOrigem;
        }

        return resultado;
    }

    private static double converterMoedaParaReal(String moeda, double valor) {
        double taxa = obterTaxaConversao(moeda);
        return valor * taxa;
    }

    private static double converterRealParaMoeda(String moeda, double valor) {
        double taxa = obterTaxaConversao(moeda);
        return valor / taxa;
    }

    private static double obterTaxaConversao(String moeda) {
        Double taxa = cotacoes.get(moeda);
        return (taxa != null) ? taxa : 1.0;
    }

    public static String formatarValor(double valor, String moeda) {
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance();
        DecimalFormatSymbols simbolos = ((DecimalFormat) formatoMoeda).getDecimalFormatSymbols();

        switch (moeda) {
            case "Reais":
                simbolos.setCurrencySymbol("R$");
                break;
            case "Dólar":
                simbolos.setCurrencySymbol("$");
                break;
            case "Euro":
                simbolos.setCurrencySymbol("€");
                break;
            case "Libras Esterlinas":
                simbolos.setCurrencySymbol("£");
                break;
            case "Peso argentino":
                simbolos.setCurrencySymbol("ARS$");
                break;
            case "Peso Chileno":
                simbolos.setCurrencySymbol("CLP$");
                break;
        }

        ((DecimalFormat) formatoMoeda).setDecimalFormatSymbols(simbolos);
        return formatoMoeda.format(valor);
    }
}
