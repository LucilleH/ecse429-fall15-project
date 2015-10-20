package group04.ca.mcgill.sel.ram.controller;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ca.mcgill.sel.commons.emf.util.AdapterFactoryRegistry;
import ca.mcgill.sel.commons.emf.util.ResourceManager;
import ca.mcgill.sel.ram.Aspect;
import ca.mcgill.sel.ram.RamPackage;
import ca.mcgill.sel.ram.provider.RamItemProviderAdapterFactory;
import ca.mcgill.sel.ram.util.RamResourceFactoryImpl;

@RunWith(Suite.class)
@SuiteClasses({TestMessageViewController.class})
public class TestSuite {
    @BeforeClass 
    public static void setUpClass() {    
        System.out.println("Master setup");
        // Initialize ResourceManager.
        ResourceManager.initialize();
        // Initialize packages.
        RamPackage.eINSTANCE.eClass();

        // Register resource factories.
        ResourceManager.registerExtensionFactory("ram", new RamResourceFactoryImpl());

        // Initialize adapter factories.
        AdapterFactoryRegistry.INSTANCE.addAdapterFactory(RamItemProviderAdapterFactory.class);
    
        Aspect aspect = (Aspect) ResourceManager.loadModel("path/to/the/concern/Aspect.ram");
    }

    @AfterClass 
    public static void tearDownClass() { 
        System.out.println("Master tearDown");
    }

}
