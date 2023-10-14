import java.util.Date;

class Cliente {
    private String tipoCliente;
    
    // Construtor
    public Cliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    // Getter
    public String getTipoCliente() {
        return tipoCliente;
    }
}

class Conta {
    private String tipoConta;
    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    private Cliente cliente;
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    private Date dataAbertura;
    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    private double saldo;
    
    // Construtor
    public Conta(String tipoConta, Cliente cliente) {
        this.tipoConta = tipoConta;
        this.cliente = cliente;
        this.dataAbertura = new Date();
        this.saldo = 0.0;
    }
    
    // Getter
    public double getSaldo() {
        return saldo;
    }
    
    // Método para sacar um valor da conta
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
    
    // Método para depositar um valor na conta
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado com sucesso!");
    }
}

class ContaPoupanca extends Conta {
    private double taxaJuros;
    
    // Construtor
    public ContaPoupanca(Cliente cliente) {
        super("Poupança", cliente);
        this.taxaJuros = 0.05;
    }
    
    // Método para calcular o rendimento mensal da conta poupança
    public double calcularRendimentoMensal() {
        return getSaldo() * taxaJuros;
    }
}

class ContaInvestimento extends Conta {
    private double taxaRendimento;
    
    // Construtor
    public ContaInvestimento(Cliente cliente) {
        super("Investimento", cliente);
        this.taxaRendimento = 0.1;
    }
    
    // Método para calcular o rendimento diário da conta investimento
    public double calcularRendimentoDiario() {
        return getSaldo() * taxaRendimento / 30;
    }
}

public class main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Pessoa Física");
        
        ContaPoupanca contaPoupanca1 = new ContaPoupanca(cliente1);
        contaPoupanca1.depositar(1000.0);
        contaPoupanca1.sacar(500.0);
        System.out.println("Rendimento mensal da conta poupança: " + contaPoupanca1.calcularRendimentoMensal());
        
        ContaInvestimento contaInvestimento1 = new ContaInvestimento(cliente1);
        contaInvestimento1.depositar(2000.0);
        contaInvestimento1.sacar(1000.0);
        System.out.println("Rendimento diário da conta investimento: " + contaInvestimento1.calcularRendimentoDiario());
        
        // Tentativa de saque com saldo insuficiente
        contaPoupanca1.sacar(1500.0);
        contaInvestimento1.sacar(2500.0);
    }
}