package com.dunzhixuan.constacts;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.btn_isexist_constacts).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				boolean isExist = isThePhoneExist(MainActivity.this, "VIPKID1对1客服");
				Log.e("TBG", "isExist==" + isExist);
			}
		});

		findViewById(R.id.btn_save_constact).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				saveConstact(0);
			}
		});

		findViewById(R.id.btn_save_constacts).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				for (int i = 0; i < 10; i++) {
					saveConstact(i);
				}
			}
		});
	}

	/*
	 * 写入通讯录
	 * */
	private void saveConstact(int num) {
		//插入raw_contacts表，并获取_id属性
		Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
		ContentResolver resolver = getContentResolver();
		ContentValues values = new ContentValues();
		long contact_id = ContentUris.parseId(resolver.insert(uri, values));
		//插入data表
		uri = Uri.parse("content://com.android.contacts/data");
		//add Name
		values.put("raw_contact_id", contact_id);
		values.put(ContactsContract.Data.MIMETYPE, "vnd.android.cursor.item/name");
		values.put("data1", "VIPKID1对1客服" + num);
		resolver.insert(uri, values);
		values.clear();
		//add Phone
		values.put("raw_contact_id", contact_id);
		values.put(ContactsContract.Data.MIMETYPE, "vnd.android.cursor.item/phone_v2");
		values.put("data1", "87654321");
		resolver.insert(uri, values);
		values.clear();
		//add Phone2
		values.put("raw_contact_id", contact_id);
		values.put(ContactsContract.Data.MIMETYPE, "vnd.android.cursor.item/phone_v2");
		values.put("data1", "15232138797");
		resolver.insert(uri, values);
		values.clear();
		//add email
		values.put("raw_contact_id", contact_id);
		values.put(ContactsContract.Data.MIMETYPE, "vnd.android.cursor.item/email_v2");
		values.put("data1", "xzdong@xzdong.com");
		resolver.insert(uri, values);

//		//写入手机号码
//		values.clear();
//		values.put(ContactsContract.Data.RAW_CONTACT_ID, contact_id);
//		values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
//		values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, "15232138798");
//		values.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE);
//		//插入data表
//		resolver.insert(uri, values);
	}

	/*
	 * 批量写入通讯录
	 * */
	private void saveConstacts() {

	}

	/**
	 * 添加联系人信息
	 *
	 */
//	public static void insertConstacts(Context context, String name, List<String> list) {
//		try {
//			//该店管家用户是否存在，存在的话，就追加号码，不存在新增联系人
//			long rawContactId = getContactsId(context, name);
//			ContentValues values = new ContentValues();
//
//			if (rawContactId == 0 ) {
//				//插入raw_contacts表，并获取_id属性
//				Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
//				ContentResolver resolver = context.getContentResolver();
//				rawContactId = ContentUris.parseId(resolver.insert(uri, values));
//
//				//插入data表
//				uri = Uri.parse("content://com.android.contacts/data");
//
//				//add Name
//				values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
//				values.put(ContactsContract.Data.MIMETYPE, "vnd.android.cursor.item/name");
//				values.put(ContactsContract.CommonDataKinds.StructuredName.GIVEN_NAME, name);
//				resolver.insert(uri, values);
//				values.clear();
//
//				//写入头像
//				Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_poraital);
//				ByteArrayOutputStream out = new ByteArrayOutputStream();
//				bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
//				out.flush();
//				out.close();
//				values.clear();
//				values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
//				values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Photo.CONTENT_ITEM_TYPE);
//				values.put(ContactsContract.CommonDataKinds.Photo.PHOTO, out.toByteArray());
//				context.getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);
//
//			}
//
//			//写入手机号码
//			values.clear();
//			values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
//			values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
//			values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, phone1);
//			values.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE);
//			//插入data表
//			Uri uri = Uri.parse("content://com.android.contacts/data");
//			context.getContentResolver().insert(uri, values);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

	/**
	 * 判断某个手机号是否存在
	 */
	public static boolean isThePhoneExist(Context context, String phoneNum) {
		//uri=  content://com.android.contacts/data/phones/filter/#
		Cursor cursor = null;
		try {
			Uri uri = Uri.parse("content://com.android.contacts/data/phones/filter/" + phoneNum);
			ContentResolver resolver = context.getContentResolver();
			cursor = resolver.query(uri, new String[]{ContactsContract.Data.DISPLAY_NAME},
							null, null, null); //从raw_contact表中返回display_name
			if (cursor != null && cursor.moveToFirst()) {
				cursor.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cursor != null) {
				cursor.close();
			}
		}

		return false;
	}

}
