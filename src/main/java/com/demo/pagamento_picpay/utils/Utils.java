package com.demo.pagamento_picpay.utils;

public class Utils {

    //Metodo para formatar o CPF
    public static String formatarCpf(String cpf) {

        if(cpf.length() < 11) 
            throw new IllegalArgumentException("CPF inválido");
        
        return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
    }

    // Metodo para formatar o telefone com o formato (xx) xxxxx-xxxx
    public static String formatarTelefone(String telefone) {

        if(telefone.length() < 11) 
            throw new IllegalArgumentException("Telefone inválido");

        return "(" + telefone.substring(0, 2) + ") " + telefone.substring(2, 7) + "-" + telefone.substring(7);
    }

    //Metodo para formatar o cnpj
    public static String formatarCnpj(String cnpj) {

        if(cnpj.length() < 14) 
            throw new IllegalArgumentException("CNPJ inválido");
        
        return cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12) + "-" + cnpj.substring(12);
    }

}
