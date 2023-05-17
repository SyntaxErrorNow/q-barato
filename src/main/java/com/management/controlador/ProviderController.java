package com.management.controlador;
import com.management.modelo.schema.Proveedor;
import javax.swing.JOptionPane;
import org.bson.types.ObjectId;
import com.management.modelo.service.ProviderService;

public class ProviderController {

    private ProviderService providerService;

    public ProviderController() {
        providerService = new ProviderService();
    }


    public void registrarProviderById(Proveedor provider){
        try {
            providerService.createProvider(provider);
            JOptionPane.showMessageDialog(null, "El proveedor se registró exitosamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar el proveedor");
            throw new RuntimeException("Error al registrar el proveedor: " + e.getMessage());
        }
    }

    public void eliminarProviderById(ObjectId id) {
        try {
            providerService.deleteProviderById(id);
            JOptionPane.showMessageDialog(null, "El proveedor se eliminó exitosamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el proveedor");
            throw new RuntimeException("Error al eliminar el proveedor: " + e.getMessage());
        }
    }



    public void actualizarProviderById(Proveedor provider){
        try {
            providerService.updateProviderById(provider.getId(), provider);
            JOptionPane.showMessageDialog(null, "El proveedor se actualizó exitosamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el proveedor");
            throw new RuntimeException("Error al actualizar el proveedor: " + e.getMessage());
        }
    }

}
