package stackİleMatematik;

import javax.swing.SpringLayout;

public class Main extends javax.swing.JFrame {

    String postfix;
    String infix;
    Stack stack;

    public Main() {
        initComponents();
        stack = new Stack();
        postfix = "";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel1.setText("Hesaplanacak İfade");

        jButton1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jButton1.setText("Hesapla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel2.setText("Sonuç :");

        jTextField1.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jLabel2))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Operatörler arasında öncelik belirler
    public int calcValue(char val) {
        if (val == '+' || val == '-') {
            return 1;
        } else if (val == '*' || val == '/') {
            return 2;
        }
        return 0;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        infix = jTextField1.getText();
        for (int i = 0; i < infix.length(); i++) {
            switch (infix.charAt(i)) {
                case '(', '{', '[' ->//parantez açılan durumlarda çalışacak kısım
                    stack.push("" + infix.charAt(i));
                case '+', '-', '*', '/' -> {//operatör değeri geldiğinde çalışacak kısım
                    if (stack.isEmpty() == true || stack.peek().equals("(")) {
                        stack.push("" + infix.charAt(i));
                    } else if (calcValue(stack.peek().charAt(0)) < calcValue(infix.charAt(i))) {
                        stack.push(infix.charAt(i) + "");
                    } else if (calcValue(stack.peek().charAt(0)) >= calcValue(infix.charAt(i))) {
                        postfix += stack.pop() + " ";
                        stack.push(infix.charAt(i) + "");
                    }
                }
                case ')' -> {//parantez kapandığında çalışacak kısım
                    while (stack.peek() != null) {
                        if ("(".equals(stack.peek())) {
                            stack.pop();
                            break;
                        }
                        postfix += stack.pop() + " ";
                    }
                }
                default -> {//girilen değerlerin yukarıdakilerden farklı olduğu durumlarda çalışacak kısım
                    if (infix.charAt(i) != ' ') {
                        if (i < infix.length() - 1 && infix.charAt(i + 1) >= '0' && infix.charAt(i + 1) <= '9'&& infix.charAt(i) >= '0' && infix.charAt(i) <= '9') {
                            postfix += infix.charAt(i);
                            postfix += infix.charAt(i + 1) + " ";
                            i++;
                        } else {
                            postfix += infix.charAt(i) + " ";
                        }
                    }
                }

            }
        }
        while (!stack.isEmpty()) {//infix postfix dönüşümü sonrası yığıtta kalan değerlerin elde edilmesi
            postfix += stack.pop() + " ";
        }//yığıt artık boş
        String[] postfixArray = postfix.split(" ");
        //infix den postfixe dönüştürülen ifadenin hesaplanması
        for (String postfixArray1 : postfixArray) {
            if (postfixArray1.charAt(0) >= '0' && postfixArray1.charAt(0) <= '9') {
                stack.push(postfixArray1);
            } else if (postfixArray1.charAt(0) == '+') {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop()) + num1;
                stack.push(Integer.toString(num2));
            } else if (postfixArray1.charAt(0) == '-') {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop()) - num1;
                stack.push(Integer.toString(num2));
            } else if (postfixArray1.charAt(0) == '*') {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop()) * num1;
                stack.push(Integer.toString(num2));
            } else if (postfixArray1.charAt(0) == '/') {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop()) / num1;
                stack.push(Integer.toString(num2));
            }
        }
        //işlem sonunda elde edilen değerin yığıttan çekilmesi
        int result = Integer.parseInt(stack.pop());
        //sonucun label eyazdırılması
        jLabel2.setText("Sonuç : " + result);
        //değişken değerlerinin sıfırlanması ve jtextfieldın temizlenmesi
        infix = "";
        postfix = "";
        jTextField1.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
