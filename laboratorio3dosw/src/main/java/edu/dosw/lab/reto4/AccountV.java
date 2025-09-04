package edu.dosw.lab.reto4;

public class AccountV {

    private AccountManager accountManager;

    public AccountV(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public boolean validarCuenta(String numeroCuenta) {
        // Lógica para validar la cuenta
        // Por ejemplo, verificar si el número de cuenta existe en el sistema
        // Aquí se simula la validación con un número de cuenta fijo para el ejemplo
        return numeroCuenta == "123456"; // Simulación: solo la cuenta 123456 es válida
    }
}
