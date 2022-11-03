package StackDersUyg;

public class Main extends javax.swing.JFrame {

    String postfix;
    String infix;
    Stack stack;
    Stack islem;

    public Main() {
        stack = new Stack();
        islem = new Stack();
        initComponents();
    }

    public int calcValue(char val) {
        if (val == '+' || val == '-') {
            return 1;
        } else if (val == '*' || val == '/') {
            return 2;
        }
        return 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel1.setText("Matematiksel İfade");

        jButton1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jButton1.setText("Hesapla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel2.setText("label1");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel3.setText("label2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1))
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)))
                .addGap(51, 51, 51)
                .addComponent(jLabel3)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        infix = jTextField1.getText();
        for (int i = 0; i < infix.length(); i++) {
            switch (infix.charAt(i)) {
                case '(', '{', '[' ->//parantez açılan durumlarda çalışacak kısım
                    islem.push(String.valueOf(infix.charAt(i)));
                case '+', '-', '*', '/' -> {//operatör değeri geldiğinde çalışacak kısım
                    if (stack.isEmpty() == true || stack.peek().equals("(")) {
                        islem.push(String.valueOf(infix.charAt(i)));
                    } else if (calcValue(stack.peek().charAt(0)) < calcValue(infix.charAt(i))) {
                        islem.push(String.valueOf(infix.charAt(i)));
                    } else if (calcValue(stack.peek().charAt(0)) >= calcValue(infix.charAt(i))) {
                        String tutucu = String.valueOf(stack.pop());
                        islem.push(String.valueOf(infix.charAt(i)));
                        islem.push(tutucu);
                    }
                }
                case ')' -> {//parantez kapandığında çalışacak kısım
                    islem.push(String.valueOf(infix.charAt(i)));
                }
                default -> {//girilen değerlerin yukarıdakilerden farklı olduğu durumlarda çalışacak kısım
                    if (infix.charAt(i) != ' ') {
                        if (i < infix.length() - 1 && infix.charAt(i + 1) >= '0' && infix.charAt(i + 1) <= '9' && infix.charAt(i) >= '0' && infix.charAt(i) <= '9') {
                            stack.push(String.valueOf(infix.charAt(i) + infix.charAt(i + 1)));
                            i++;
                        } else {
                            stack.push(String.valueOf(infix.charAt(i)));
                        }
                    }
                }

            }
        }
        String sonuc1 = "";
        while (islem.peek() != "null") {
            sonuc1 += islem.pop();
        }
        String sonuc2 = "";
        while (stack.peek() != "null") {
            sonuc2 += stack.pop();
        }
        //sonucun label eyazdırılması
        jLabel2.setText(sonuc1);
        jLabel3.setText(sonuc2);
        //değişken değerlerinin sıfırlanması ve jtextfieldın temizlenmesi
        infix = "";
        postfix = "";
        jTextField1.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
