package Desenvolvimento;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import Desenvolvimento.cliente.contracts.IClient;

public class ControladorDeArquivos {
    public static List<IClient> lerArquivo(String path) throws IOException {
        FileInputStream file = new FileInputStream(path);
        if (file.available() > 0) {
            ObjectInputStream gravar = new ObjectInputStream(file);
            List<IClient> allLines = new ArrayList<IClient>();
            try {
                IClient cliente = (IClient) gravar.readObject();
                while (cliente != null) {
                    allLines.add(cliente);
                    cliente = (IClient) gravar.readObject();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }

            gravar.close();

            return allLines;
        }
        file.close();
        return List.of();
    }

    public static void escreveBinario(String path, List<IClient> clientes) throws IOException {
        ObjectOutputStream gravar = new ObjectOutputStream(new FileOutputStream(path));

        for (IClient c : clientes) {
            gravar.writeObject(c);
        }

        gravar.close();
    }

    public static void salvarClient(String path, IClient client) throws IOException {
        final List<IClient> clients = lerArquivo(path);
        final List<IClient> updatedClientList = clients.stream()
                .filter((cli) -> cli.getIdentificador().equals(client.getIdentificador())).collect(Collectors.toList());
        updatedClientList.add(client);
        escreveBinario(path, updatedClientList);
    }
}