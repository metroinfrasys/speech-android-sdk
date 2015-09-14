/**
 * Copyright IBM Corporation 2015
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/

package com.ibm.cio.opus;

import java.io.File;
import java.io.IOException;
import org.xiph.speex.AudioFileWriter;
import com.ibm.cio.audio.ChuckWebSocketUploader;

public class ChuckOpusWriter extends AudioFileWriter {
    private ChuckWebSocketUploader client;

    public ChuckOpusWriter(ChuckWebSocketUploader client){
        this.client = client;
    }

    @Override
    public void close() throws IOException {
        this.client.stop();
    }

    @Override
    public void open(File file) throws IOException {
    }

    @Override
    public void open(String filename) throws IOException {
    }

    @Override
    public void writeHeader(String comment) {}

    @Override
    public void writePacket(byte[] data, int offset, int len)
            throws IOException {
        this.client.upload(data);
    }
}
