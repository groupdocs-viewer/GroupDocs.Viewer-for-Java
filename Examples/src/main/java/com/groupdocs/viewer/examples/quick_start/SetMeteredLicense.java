package com.groupdocs.viewer.examples.quick_start;

import com.groupdocs.viewer.Metered;

public class SetMeteredLicense {

    /**
     * This example demonstrates how to set Metered license.
     * Learn more about Metered license at https://purchase.groupdocs.com/faqs/licensing/metered.
     */

    public static void run() {
        String publicKey = "*****";
        String privateKey = "*****";

        Metered metered = new Metered();
        metered.setMeteredKey(publicKey, privateKey);

        System.out.println("License set successfully.");
    }
}