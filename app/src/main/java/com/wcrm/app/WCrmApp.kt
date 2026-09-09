package com.wcrm.app

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.wcrm.business.profile.schema.BusinessModule
import com.wcrm.core.common.config.AppConfig
import com.wcrm.feature.dashboard.DashboardScreen
import com.wcrm.feature.product.DynamicProductForm
import com.wcrm.runtime.RuntimeBootstrap
import com.wcrm.runtime.RuntimeContext
import kotlinx.coroutines.launch

private enum class AppSection { HOME, MODULES, PRODUCT_FORM, SETTINGS, NOTIFICATIONS, ABOUT, CONTACT, SHARE, BACKUP, UPDATE }

/**
 * پوسته عمومی همه برنامه‌های ساخته‌شده از این Core.
 * Header، Drawer و سیاست Back در یک نقطه نگه‌داری می‌شوند و محتوای تخصصی از Runtime Profile می‌آید.
 */
@Composable
fun WCrmApp() {
    val runtime = remember { RuntimeBootstrap.initialize() }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var section by remember { mutableStateOf(AppSection.HOME) }
    var showProfileDialog by remember { mutableStateOf(false) }

    // هر مقصد غیر از خانه با Back مستقیماً به خانه برمی‌گردد؛ تاریخچه منوها بازپخش نمی‌شود.
    BackHandler(enabled = section != AppSection.HOME || drawerState.isOpen) {
        if (drawerState.isOpen) scope.launch { drawerState.close() }
        else section = AppSection.HOME
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            AppDrawer(
                activeProfileName = runtime.businessProfile.name,
                onProfileClick = { showProfileDialog = true },
                onSectionSelected = {
                    section = it
                    scope.launch { drawerState.close() }
                }
            )
        }
    ) {
        Scaffold(
            topBar = {
                AppTopBar(
                    onDrawerClick = { scope.launch { drawerState.open() } },
                    onModulesClick = { section = AppSection.MODULES }
                )
            }
        ) { padding ->
            Box(Modifier.padding(padding).fillMaxSize()) {
                when (section) {
                    AppSection.HOME -> DashboardScreen(runtime.businessProfile)
                    AppSection.MODULES -> ProfileSchemaPage(
                        runtime = runtime,
                        onOpenProductForm = { section = AppSection.PRODUCT_FORM }
                    )
                    AppSection.PRODUCT_FORM -> DynamicProductForm(runtime.businessProfile)
                    AppSection.SETTINGS -> SimplePage("تنظیمات\nپروفایل فعال: ${runtime.businessProfile.name}\nTheme: ${runtime.theme.themeKey}")
                    AppSection.NOTIFICATIONS -> SimplePage("اعلان‌ها\nشما اعلان جدیدی ندارید")
                    AppSection.ABOUT -> SimplePage("درباره نرم‌افزار\n${AppConfig.Company.aboutText}\n\n${AppConfig.Company.displayName}")
                    AppSection.CONTACT -> SimplePage("تماس با ما\n${AppConfig.Company.contactText}\n\n${AppConfig.Company.supportEmail}")
                    AppSection.SHARE -> SimplePage("معرفی به دوستان")
                    AppSection.BACKUP -> BackupRestorePage()
                    AppSection.UPDATE -> SimplePage("بروزرسانی\nنسخه فعلی: ${AppConfig.Identity.versionName}")
                }
            }
        }
    }

    if (showProfileDialog) {
        AlertDialog(
            onDismissRequest = { showProfileDialog = false },
            confirmButton = { TextButton(onClick = { showProfileDialog = false }) { Text("باشه") } },
            title = { Text("تصویر پروفایل") },
            text = { Text("مسیر انتخاب، زوم و کراپ تصویر پروفایل از همین نقطه به Image Picker متصل می‌شود.") }
        )
    }
}

@Composable
private fun AppTopBar(onDrawerClick: () -> Unit, onModulesClick: () -> Unit) {
    Surface(shadowElevation = 4.dp) {
        Row(
            modifier = Modifier.fillMaxWidth().height(64.dp).padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("☰", modifier = Modifier.clickable(onClick = onDrawerClick).padding(12.dp))
            Text(AppConfig.Identity.appName, fontWeight = FontWeight.Bold)
            Text("▦", modifier = Modifier.clickable(onClick = onModulesClick).padding(12.dp))
        }
    }
}

@Composable
private fun AppDrawer(
    activeProfileName: String,
    onProfileClick: () -> Unit,
    onSectionSelected: (AppSection) -> Unit
) {
    ModalDrawerSheet(modifier = Modifier.width(310.dp)) {
        Spacer(Modifier.height(24.dp))
        Surface(
            modifier = Modifier.align(Alignment.CenterHorizontally).size(84.dp).clip(CircleShape).clickable(onClick = onProfileClick),
            shape = CircleShape,
            tonalElevation = 4.dp
        ) { Box(contentAlignment = Alignment.Center) { Text("پروفایل") } }
        Text(activeProfileName, modifier = Modifier.align(Alignment.CenterHorizontally).padding(8.dp), fontWeight = FontWeight.Bold)
        HorizontalDivider(Modifier.padding(vertical = 8.dp))

        DrawerRow("⚙", "تنظیمات") { onSectionSelected(AppSection.SETTINGS) }
        DrawerRow("●", "اعلان‌ها") { onSectionSelected(AppSection.NOTIFICATIONS) }
        if (AppConfig.Drawer.aboutEnabled) DrawerRow("ⓘ", "درباره نرم‌افزار") { onSectionSelected(AppSection.ABOUT) }
        if (AppConfig.Drawer.contactEnabled) DrawerRow("✉", "تماس با ما") { onSectionSelected(AppSection.CONTACT) }
        if (AppConfig.Drawer.shareEnabled) DrawerRow("↗", "معرفی به دوستان") { onSectionSelected(AppSection.SHARE) }
        if (AppConfig.Drawer.backupRestoreEnabled) DrawerRow("↻", "پشتیبان‌گیری") { onSectionSelected(AppSection.BACKUP) }
        if (AppConfig.Drawer.updateEnabled) DrawerRow("↓", "آپدیت   ${AppConfig.Identity.versionName}") { onSectionSelected(AppSection.UPDATE) }

        Spacer(Modifier.weight(1f))
        Text(AppConfig.Company.displayName, modifier = Modifier.align(Alignment.CenterHorizontally).padding(20.dp))
    }
}

@Composable
private fun DrawerRow(icon: String, title: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick).padding(horizontal = 20.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(icon)
        Spacer(Modifier.width(16.dp))
        Text(title)
    }
}

/**
 * خروجی نمایشی Schema فعال.
 * این صفحه نشان می‌دهد ماژول‌ها و فیلدهای UI از Profile خوانده شده‌اند.
 */
@Composable
private fun ProfileSchemaPage(
    runtime: RuntimeContext,
    onOpenProductForm: () -> Unit
) {
    Column(
        Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("بخش‌های ${runtime.businessProfile.name}", style = MaterialTheme.typography.titleLarge)

        if (runtime.isModuleEnabled(BusinessModule.PRODUCT)) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onOpenProductForm
            ) {
                Text("ثبت ${runtime.terminology.productLabel}")
            }
        }

        Text("ماژول‌های فعال", fontWeight = FontWeight.Bold)
        runtime.businessProfile.enabledModules.sortedBy { it.name }.forEach { module ->
            Card(Modifier.fillMaxWidth()) { Text(module.name, Modifier.padding(14.dp)) }
        }

        Spacer(Modifier.height(8.dp))
        Text("فیلدهای تخصصی ${runtime.terminology.productLabel}", fontWeight = FontWeight.Bold)
        runtime.attributes.forEach { field ->
            Card(Modifier.fillMaxWidth()) {
                Row(Modifier.fillMaxWidth().padding(14.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(field.name)
                    Text(if (field.required) "الزامی" else field.type.name, style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}

@Composable
private fun SimplePage(text: String) {
    Box(Modifier.fillMaxSize().padding(24.dp), contentAlignment = Alignment.TopCenter) { Text(text) }
}

@Composable
private fun BackupRestorePage() {
    Column(Modifier.fillMaxSize().padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("پشتیبان‌گیری و بازیابی", fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(24.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Button(onClick = { /* اتصال به BackupManager در فاز Data I/O */ }) { Text("Backup") }
            OutlinedButton(onClick = { /* اتصال به File Picker و RestoreManager */ }) { Text("Restore") }
        }
    }
}
