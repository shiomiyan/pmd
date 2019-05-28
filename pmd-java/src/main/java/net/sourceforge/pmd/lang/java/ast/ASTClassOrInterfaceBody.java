/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.ast;

import net.sourceforge.pmd.annotation.InternalApi;

/**
 * Represents the body of a {@linkplain ASTClassOrInterfaceDeclaration class or interface declaration}.
 * This includes anonymous classes, including those defined within an {@linkplain ASTEnumConstant enum constant}.
 *
 * <pre>
 *
 * ClassOrInterfaceBody ::=  "{"  {@linkplain ASTClassOrInterfaceBodyDeclaration ClassOrInterfaceBodyDeclaration}* "}"
 *
 * </pre>
 */
public class ASTClassOrInterfaceBody extends AbstractJavaNode {

    @InternalApi
    @Deprecated
    public ASTClassOrInterfaceBody(int id) {
        super(id);
    }

    @InternalApi
    @Deprecated
    public ASTClassOrInterfaceBody(JavaParser p, int id) {
        super(p, id);
    }

    /**
     * Accept the visitor.
     */
    @Override
    public Object jjtAccept(JavaParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

    public boolean isAnonymousInnerClass() {
        return jjtGetParent() instanceof ASTAllocationExpression;
    }

    public boolean isEnumChild() {
        return jjtGetParent() instanceof ASTEnumConstant;
    }
}
