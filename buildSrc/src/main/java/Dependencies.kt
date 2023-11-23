object Dependencies {
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtxVersion}" }
    val lifecycleRuntime by lazy {"androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeVersion}"}
    val activityCompose by lazy{"androidx.activity:activity-compose:${Versions.activityComposeVersion}"}
    val composeBom by lazy {"androidx.compose:compose-bom:${Versions.composeBomVersion}"}
    val ComposeUI by lazy {"androidx.compose.ui:ui"}
    val ComposeGraphics by lazy {"androidx.compose.ui:ui-graphics"}
    val ComposeToolingPreview by lazy {"androidx.compose.ui:ui-tooling-preview"}
    val Composematerial3 by lazy {"androidx.compose.material3:material3"}
    val Composematerial by lazy {"com.google.android.material:material:${Versions.composeMaterial}"}
    val junit by lazy {"junit:junit:${Versions.junitVersion}"}
    val testExtJunit by lazy {"androidx.test.ext:junit:${Versions.testExtJunitVersion}"}
    val testEspresso by lazy {"androidx.test.espresso:espresso-core:${Versions.testEspressoVersion}"}
    val composeBomTest by lazy {"androidx.compose:compose-bom:${Versions.composeBomTestVersion}"}
    val testJunit4 by lazy {"androidx.compose.ui:ui-test-junit4"}
    val tooling by lazy {"androidx.compose.ui:ui-tooling"}
    val testManifest by lazy {"androidx.compose.ui:ui-test-manifest"}
    val appCompat by lazy {"androidx.appcompat:appcompat:${Versions.appCompatVersion}"}
}

object Modules {
    const val utilities = ":utilities"
}