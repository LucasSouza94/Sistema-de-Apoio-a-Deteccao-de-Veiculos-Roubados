/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.beans;

/**
 *
 * @author User
 */
public class Veiculo {
    private String Ultimo_Licenciamento;
    private String Proprietário;
    private String Placa;
    private String Combustível;
    private String MarcaModelo;
    private String EspécieTipo;
    private String AnoFabricação;
    private String AnoModelo;
    private String Categoria;
    private String CorPredominante;
    private String VencimentoLicenciamento;
    private String Restrição;
    private String Financeira;
    private String Município;
    private String Situação;
    private String DataConsulta;

    public Veiculo() {
    }
    
    

    public Veiculo(String Último_Licenciamento, String Proprietário, String Placa, String Combustível, String MarcaModelo, String EspécieTipo, String AnoFabricação, String AnoModelo, String Categoria, String CorPredominante, String VencimentoLicenciamento, String Restrição, String Financeira, String Situação, String DataConsulta) {
        this.Ultimo_Licenciamento = Último_Licenciamento;
        this.Proprietário = Proprietário;
        this.Placa = Placa;
        this.Combustível = Combustível;
        this.MarcaModelo = MarcaModelo;
        this.EspécieTipo = EspécieTipo;
        this.AnoFabricação = AnoFabricação;
        this.AnoModelo = AnoModelo;
        this.Categoria = Categoria;
        this.CorPredominante = CorPredominante;
        this.VencimentoLicenciamento = VencimentoLicenciamento;
        this.Restrição = Restrição;
        this.Financeira = Financeira;
        this.Situação = Situação;
        this.DataConsulta = DataConsulta;
    }

    public String getUltimo_Licenciamento() {
        return Ultimo_Licenciamento;
    }

    public void setUltimo_Licenciamento(String Ultimo_Licenciamento) {
        this.Ultimo_Licenciamento = Ultimo_Licenciamento;
    }

    public String getProprietário() {
        return Proprietário;
    }

    public void setProprietário(String Proprietário) {
        this.Proprietário = Proprietário;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getCombustível() {
        return Combustível;
    }

    public void setCombustível(String Combustível) {
        this.Combustível = Combustível;
    }

    public String getMarcaModelo() {
        return MarcaModelo;
    }

    public void setMarcaModelo(String MarcaModelo) {
        this.MarcaModelo = MarcaModelo;
    }

    public String getEspécieTipo() {
        return EspécieTipo;
    }

    public void setEspécieTipo(String EspécieTipo) {
        this.EspécieTipo = EspécieTipo;
    }

    public String getAnoFabricação() {
        return AnoFabricação;
    }

    public void setAnoFabricação(String AnoFabricação) {
        this.AnoFabricação = AnoFabricação;
    }

    public String getAnoModelo() {
        return AnoModelo;
    }

    public void setAnoModelo(String AnoModelo) {
        this.AnoModelo = AnoModelo;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getCorPredominante() {
        return CorPredominante;
    }

    public void setCorPredominante(String CorPredominante) {
        this.CorPredominante = CorPredominante;
    }

    public String getVencimentoLicenciamento() {
        return VencimentoLicenciamento;
    }

    public void setVencimentoLicenciamento(String VencimentoLicenciamento) {
        this.VencimentoLicenciamento = VencimentoLicenciamento;
    }

    public String getRestrição() {
        return Restrição;
    }

    public void setRestrição(String Restrição) {
        this.Restrição = Restrição;
    }

    public String getFinanceira() {
        return Financeira;
    }

    public void setFinanceira(String Financeira) {
        this.Financeira = Financeira;
    }

    public String getMunicípio() {
        return Município;
    }

    public void setMunicípio(String Município) {
        this.Município = Município;
    }

    public String getSituação() {
        return Situação;
    }

    public void setSituação(String Situação) {
        this.Situação = Situação;
    }

    public String getDataConsulta() {
        return DataConsulta;
    }

    public void setDataConsulta(String DataConsulta) {
        this.DataConsulta = DataConsulta;
    }
    
    
}
