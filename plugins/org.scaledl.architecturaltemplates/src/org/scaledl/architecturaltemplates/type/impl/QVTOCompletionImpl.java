/**
 */
package org.scaledl.architecturaltemplates.type.impl;

import org.eclipse.emf.ecore.EClass;
import org.scaledl.architecturaltemplates.type.QVTOCompletion;
import org.scaledl.architecturaltemplates.type.TypePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>QVTO Completion</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.scaledl.architecturaltemplates.type.impl.QVTOCompletionImpl#getQvtoFileURI <em>Qvto File URI</em>}</li>
 * </ul>
 *
 * @generated
 */
public class QVTOCompletionImpl extends CompletionImpl implements QVTOCompletion {

    /**
     * The default value of the '{@link #getQvtoFileURI() <em>Qvto File URI</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getQvtoFileURI()
     * @generated
     * @ordered
     */
    protected static final String QVTO_FILE_URI_EDEFAULT = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected QVTOCompletionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TypePackage.Literals.QVTO_COMPLETION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getQvtoFileURI() {
        return (String) eDynamicGet(TypePackage.QVTO_COMPLETION__QVTO_FILE_URI,
                TypePackage.Literals.QVTO_COMPLETION__QVTO_FILE_URI, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setQvtoFileURI(String newQvtoFileURI) {
        eDynamicSet(TypePackage.QVTO_COMPLETION__QVTO_FILE_URI, TypePackage.Literals.QVTO_COMPLETION__QVTO_FILE_URI,
                newQvtoFileURI);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case TypePackage.QVTO_COMPLETION__QVTO_FILE_URI:
            return getQvtoFileURI();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case TypePackage.QVTO_COMPLETION__QVTO_FILE_URI:
            setQvtoFileURI((String) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
        case TypePackage.QVTO_COMPLETION__QVTO_FILE_URI:
            setQvtoFileURI(QVTO_FILE_URI_EDEFAULT);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case TypePackage.QVTO_COMPLETION__QVTO_FILE_URI:
            return QVTO_FILE_URI_EDEFAULT == null ? getQvtoFileURI() != null
                    : !QVTO_FILE_URI_EDEFAULT.equals(getQvtoFileURI());
        }
        return super.eIsSet(featureID);
    }

} // QVTOCompletionImpl
